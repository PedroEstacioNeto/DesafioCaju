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
    @Column(name = "food_balance")
    val foodBalance: Double,
    @Column(name = "meal_balance")
    val mealBalance: Double,
    @Column(name = "cash_balance")
    val cashBalance: Double
)