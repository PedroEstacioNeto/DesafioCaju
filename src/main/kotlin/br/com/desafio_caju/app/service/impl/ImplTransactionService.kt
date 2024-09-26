package br.com.desafio_caju.app.service.impl

import br.com.desafio_caju.app.dto.TransactionRequest
import br.com.desafio_caju.app.dto.enums.TransactionStatus
import br.com.desafio_caju.app.service.TransactionService
import br.com.desafio_caju.domain.usecase.TransactionUseCase
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class ImplTransactionService(
    val useCase: TransactionUseCase
): TransactionService {
    override fun execute(transaction: TransactionRequest): TransactionStatus {
        return useCase.execute(transaction);
    }
}