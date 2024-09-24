package br.com.desafio_caju.app.service

import br.com.desafio_caju.app.dto.TransactionRequest
import br.com.desafio_caju.app.dto.TransactionResponse
import br.com.desafio_caju.domain.usecase.TransactionUseCase
import org.springframework.http.ResponseEntity

class TransactionService(
    val useCase: TransactionUseCase,

    ) {

    fun execute(transaction: TransactionRequest): ResponseEntity<TransactionResponse> {
        val result = useCase.execute(transaction);
    }

}
