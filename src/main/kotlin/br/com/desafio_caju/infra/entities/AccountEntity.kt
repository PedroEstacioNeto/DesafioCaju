package br.com.desafio_caju.infra.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import lombok.Getter
import lombok.Setter

@Getter
@Setter
@Entity(name = "set_account")
data class AccountEntity(
    @Id
    val id: String,
    @Column(name = "food_amount")
    val foodAmount: Double,
    @Column(name = "meal_amount")
    val mealAmount: Double,
    @Column(name = "cash_amount")
    val cashAmount: Double
)