package br.com.desafio_caju.infra.repositories

import br.com.desafio_caju.infra.entities.MerchantEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MerchantRepository: JpaRepository<MerchantEntity, String> {

    @Query(nativeQuery = true, value = "select * from public.merchant where merchant = :merchant")
    fun findByName(merchant: String): MerchantEntity

}