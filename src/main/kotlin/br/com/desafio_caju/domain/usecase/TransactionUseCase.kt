package br.com.desafio_caju.domain.usecase


import br.com.desafio_caju.app.dto.TransactionRequest
import br.com.desafio_caju.app.dto.enums.TransactionStatus
import org.springframework.http.ResponseEntity



interface TransactionUseCase {

    fun execute(request: TransactionRequest): TransactionStatus;


}