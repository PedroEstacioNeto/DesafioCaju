package br.com.desafio_caju.app.dto

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import org.jetbrains.annotations.NotNull
import java.util.UUID

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class TransactionRequest(
    val id: String = UUID.randomUUID().toString(),
    @field:NotNull
    val account: String,
    @field:NotNull
    val totalAmount: Double,
    @field:NotNull
    val mcc: String,
    @field:NotNull
    val merchant: String
)