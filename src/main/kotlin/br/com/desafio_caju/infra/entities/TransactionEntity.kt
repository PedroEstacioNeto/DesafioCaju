package br.com.desafio_caju.infra.entities

import br.com.desafio_caju.app.dto.TransactionRequest
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "transaction")
data class TransactionEntity(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: String,
    @Column(name = "account")
    val account: String,
    @Column(name = "total_amount")
    val totalAmount: Double,
    @Column(name = "mcc")
    val mcc: String,
    @Column(name = "merchant")
    val merchant: String,
    @Column(name = "data_transaction")
    val dataTransaction: LocalDateTime = LocalDateTime.now()
){
    constructor(transactionRequest: TransactionRequest) : this(
        id = transactionRequest.id,
        account = transactionRequest.account,
        totalAmount = transactionRequest.totalAmount,
        mcc = transactionRequest.mcc,
        merchant = transactionRequest.merchant
    )
}
