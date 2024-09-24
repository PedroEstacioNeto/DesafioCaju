package br.com.desafio_caju.infra.repositories

import br.com.desafio_caju.infra.entities.TransactionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TransactionRepository: JpaRepository<TransactionEntity, String> {

    @Query(value = "")
    fun foodTransaction();
    @Query(value = "")
    fun mealTransaction();
    @Query(value = "")
    fun cashTransaction();

}