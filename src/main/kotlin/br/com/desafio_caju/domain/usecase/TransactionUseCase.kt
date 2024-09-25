package br.com.desafio_caju.domain.usecase


import br.com.desafio_caju.app.dto.TransactionRequest
import br.com.desafio_caju.domain.mapper.TransactionMapper
import br.com.desafio_caju.infra.repositories.AccountRepository
import br.com.desafio_caju.infra.repositories.TransactionRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class TransactionUseCase (val mapper: TransactionMapper, val repository: TransactionRepository, val accountRepository: AccountRepository) {

    companion object {
        val log: Logger = LoggerFactory.getLogger(TransactionUseCase.javaClass);
    }

    fun execute(request: TransactionRequest): ResponseEntity<Any>{

        var response: HashMap<String, String>;
        var entity = mapper.toTransactionEntity(request);

        try{
            val result = repository.save(entity);
            var accountResult = accountRepository.updateBalances(result.account);
            response = hashMapOf("code" to "00");
            return  ResponseEntity.ok(response);
        }catch(e: Exception){
            response = hashMapOf("code" to "07");
            log.error("Error while transaction: "+request.id+"/ Cause Message: "+e.message);
            return  ResponseEntity.badRequest().body(response);
        }
    }


}