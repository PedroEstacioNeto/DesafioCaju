package br.com.desafio_caju.infra.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "merchant")
class MerchantEntity (
    @Id
    val id: String,
    @Column(name = "merchant")
    val merchant: String,
    @Column(name = "merchant_mcc")
    val merchantMcc: String
){
}