package br.com.desafio_caju.app.service

import br.com.desafio_caju.app.dto.TransactionRequest
import br.com.desafio_caju.app.dto.TransactionResponse
import br.com.desafio_caju.domain.usecase.TransactionUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class TransactionService (val useCase: TransactionUseCase) {

    fun execute(transaction: TransactionRequest): ResponseEntity<Any> {
        return useCase.execute(transaction);
    }

}
