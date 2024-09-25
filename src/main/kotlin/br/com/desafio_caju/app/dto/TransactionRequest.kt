package br.com.desafio_caju.app.dto

import org.jetbrains.annotations.NotNull
import java.util.UUID

data class TransactionRequest(
    val id: String = UUID.randomUUID().toString(),
    @field:NotNull
    val account: String,
    @field:NotNull
    val totalAmount: Double,
    @field:NotNull
    val mcc: String = "",
    @field:NotNull
    val merchant: String
)