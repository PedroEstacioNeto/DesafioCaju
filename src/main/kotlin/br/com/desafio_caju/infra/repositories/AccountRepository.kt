package br.com.desafio_caju.infra.repositories

import br.com.desafio_caju.infra.entities.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository: JpaRepository<AccountEntity, String> {

    @Modifying
    @Query(nativeQuery = true, value =
    "UPDATE set_account a " +
            "SET food_balance = ( " +
            "SELECT SUM(amount) " +
            "FROM transactions t " +
            "WHERE t.account_id = a.id AND t.mcc IN ('5411', '5412') " + // Example for food MCCs
            "), " +
            "meal_balance = ( " + // Similar logic for other balances based on MCCs
            "SELECT SUM(amount) " +
            "FROM transactions t " +
            "WHERE t.account_id = a.id AND t.mcc IN ('5811', '5812') " + // Example for meal MCCs
            ") " +
            "WHERE a.id = :accountId"
    )
    fun updateBalances(@Param("accountId") accountId: String): Boolean
}