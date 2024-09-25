package br.com.desafio_caju.app.rest

import br.com.desafio_caju.app.dto.TransactionRequest
import br.com.desafio_caju.app.dto.TransactionResponse
import br.com.desafio_caju.app.dto.enums.TransactionStatus
import br.com.desafio_caju.app.service.TransactionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@RestController
class TransactionController ( val service: TransactionService) {

    @PostMapping(
        value = ["/"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun transaction(@RequestBody body: TransactionRequest): ResponseEntity<TransactionResponse>{
        logger.info("method=transaction, step=controller, id={}", body.id);
        return service.execute(body).let { transactionStatus ->
            ResponseEntity.ok(TransactionResponse(transactionStatus.code))
        }
    }

    companion object{
        private val logger: Logger = LogManager.getLogger(TransactionController::class.java);
    }
}