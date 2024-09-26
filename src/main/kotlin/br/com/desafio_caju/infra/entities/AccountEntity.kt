package br.com.desafio_caju.infra.entities

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Getter
@Setter
@Entity(name = "set_account")
data class AccountEntity(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: String,
    @Column(name = "food_balance")
    var foodBalance: Double,
    @Column(name = "meal_balance")
    var mealBalance: Double,
    @Column(name = "cash_balance")
    var cashBalance: Double
)