package br.com.desafio_caju.domain.usecase


import br.com.desafio_caju.app.dto.TransactionRequest
import br.com.desafio_caju.domain.mapper.TransactionMapper
import br.com.desafio_caju.infra.repositories.TransactionRepository

class TransactionUseCase(val mapper: TransactionMapper, val repository: TransactionRepository) {

    fun execute(request: TransactionRequest){
        var entity = mapper.toTransactionEntity(request);
        val result = when(entity.mcc){
            "5412"-> repository.foodTransaction()
            "5411" -> repository.foodTransaction()
            "5811"-> repository.mealTransaction()
            "5812"-> repository.mealTransaction()
            else -> repository.cashTransaction()
        }
        return result;
    }

}