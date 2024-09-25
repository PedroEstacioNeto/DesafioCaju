package br.com.desafio_caju.domain.mapper

import br.com.desafio_caju.app.dto.TransactionRequest
import br.com.desafio_caju.infra.entities.TransactionEntity
import org.springframework.stereotype.Component

@Component
class TransactionMapper {

     fun toTransactionEntity(request: TransactionRequest): TransactionEntity {
        return TransactionEntity(
            id = request.id,
            totalAmount = request.totalAmount,
            mcc = request.mcc,
            merchant = request.merchant,
            account = request.account
        )
    }

}