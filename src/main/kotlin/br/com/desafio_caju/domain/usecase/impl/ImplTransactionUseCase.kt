package br.com.desafio_caju.domain.usecase.impl

import br.com.desafio_caju.app.configuration.MccValues
import br.com.desafio_caju.app.dto.TransactionRequest
import br.com.desafio_caju.app.dto.enums.TransactionStatus
import br.com.desafio_caju.domain.mapper.TransactionMapper
import br.com.desafio_caju.domain.usecase.TransactionUseCase
import br.com.desafio_caju.infra.entities.AccountEntity
import br.com.desafio_caju.infra.entities.enums.AmountType
import br.com.desafio_caju.infra.repositories.AccountRepository
import br.com.desafio_caju.infra.repositories.MerchantRepository
import br.com.desafio_caju.infra.repositories.TransactionRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ImplTransactionUseCase(
    val mccValues: MccValues,
    val mapper: TransactionMapper,
    val repository: TransactionRepository,
    val accountRepository: AccountRepository,
    val merchantRepository: MerchantRepository
): TransactionUseCase {

    override fun execute(request: TransactionRequest): TransactionStatus{

        var response: TransactionStatus = TransactionStatus.APPROVED;
        var entity = mapper.toTransactionEntity(request);

        try{
            val account = accountRepository.findById(entity.account);

            if (account.isPresent){

                val amountType = validateTransactionType(request);
                logger.info("method=transaction, step=usecase, AmountTpe={}", amountType);

                response = when {
                    validateBalanceIsViable(request, account.get(), amountType) -> {
                        accountRepository.saveAndFlush(efetuarDebito(request, account.get(), amountType ))
                        repository.save(entity);
                        logger.info("method=updateBalance, step=usecase, id={}", account.get().id);
                        TransactionStatus.APPROVED;
                    }
                    else -> {
                        logger.info("method=updateBalance, step=usecase, id={}", account.get().id);
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


    private fun validateTransactionType(request: TransactionRequest): AmountType {
        if(request.mcc.isEmpty() || request.mcc.isBlank()){
            val merchant = merchantRepository.findByName(request.merchant);
            return getAmountType(merchant.merchantMcc);
        }else{
            return getAmountType(request.mcc);
        }
    }

    private fun validateBalanceIsViable(request: TransactionRequest, account: AccountEntity, mccType: AmountType): Boolean{
        return when(mccType){
            AmountType.CASH -> account.cashBalance >= request.totalAmount
            AmountType.FOOD -> account.foodBalance >= request.totalAmount
            AmountType.MEAL -> account.mealBalance >= request.totalAmount
        }

    }

    protected fun getAmountType(mcc: String): AmountType{
        return when {
            mcc.isBlank() -> AmountType.CASH
            mccValues.food.contains(mcc) -> AmountType.FOOD
            mccValues.meal.contains(mcc) -> AmountType.MEAL
            else -> AmountType.CASH
        }
    }

    private fun efetuarDebito(request: TransactionRequest, account: AccountEntity, mccType: AmountType): AccountEntity{
         when(mccType){
            AmountType.CASH -> account.cashBalance = account.cashBalance - request.totalAmount
            AmountType.FOOD -> account.foodBalance = account.foodBalance - request.totalAmount
            AmountType.MEAL -> account.mealBalance = account.mealBalance - request.totalAmount
        }
        return account;
    }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(TransactionUseCase::class.java.javaClass);
    }
}