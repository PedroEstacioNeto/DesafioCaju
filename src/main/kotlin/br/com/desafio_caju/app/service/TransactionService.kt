package br.com.desafio_caju.app.service

import br.com.desafio_caju.app.dto.TransactionRequest
import br.com.desafio_caju.app.dto.TransactionResponse
import br.com.desafio_caju.app.dto.enums.TransactionStatus
import br.com.desafio_caju.domain.usecase.TransactionUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

interface TransactionService {

    fun execute(transaction: TransactionRequest): TransactionStatus ;

}
