package br.com.kotlinspringservice.resources.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TransferRepositoryJPA : CrudRepository<TransferDataEntity, String> {
    fun findAllByShippingAccount(shippingAccount: String) : List<TransferDataEntity>
}