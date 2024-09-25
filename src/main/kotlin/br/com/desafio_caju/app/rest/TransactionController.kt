package br.com.desafio_caju.app.rest

import br.com.desafio_caju.app.dto.TransactionRequest
import br.com.desafio_caju.app.dto.TransactionResponse
import br.com.desafio_caju.app.service.TransactionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TransactionController ( val service: TransactionService) {

    @PostMapping(
        value = ["/"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun transaction(@RequestBody body: TransactionRequest): ResponseEntity<Any>{
        return service.execute(body);
    }

}