package br.com.desafio_caju.domain.usecase.impl

import br.com.desafio_caju.app.dto.TransactionRequest
import br.com.desafio_caju.app.dto.enums.TransactionStatus
import br.com.desafio_caju.domain.mapper.TransactionMapper
import br.com.desafio_caju.domain.usecase.TransactionUseCase
import br.com.desafio_caju.infra.repositories.AccountRepository
import br.com.desafio_caju.infra.repositories.TransactionRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ImplTransactionUseCase(
    val mapper: TransactionMapper,
    val repository: TransactionRepository,
    val accountRepository: AccountRepository
): TransactionUseCase {

    override fun execute(request: TransactionRequest): TransactionStatus{

        var response: TransactionStatus = TransactionStatus.APPROVED;
        var entity = mapper.toTransactionEntity(request);

        try{
            val account = accountRepository.findById(entity.account);
            if (account.isPresent){
                response = when {
                    accountRepository.updateBalances(account.get().id) -> {
                        repository.save(entity);
                        logger.info("method=transaction, step=usecase, id={}", account.get().id);
                        TransactionStatus.APPROVED;
                    }
                    else -> {
                        logger.info("method=transaction, step=usecase, id={}", account.get().id);
                        logger.error("Saldo insuficiente para transaçao, id={}", account.get().id);
                        TransactionStatus.REPROVED;
                    }
                }
            }
        }catch(e: Exception){
            logger.info("Erro ao executar transação, id={}", entity.id);
            logger.error("Exception doing transaction, message={}", e.message);
           response = TransactionStatus.PROBLEM;
        }
        return response;
    }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(TransactionUseCase::class.java.javaClass);
    }
}