package br.com.desafio_caju.app.dto

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.Setter

@Getter
@Setter
@AllArgsConstructor
data class TransactionResponse(val code: String)
