package br.com.kotlinspringservice.domain.repositories

import br.com.kotlinspringservice.resources.repositories.TransferDataEntity

interface TransferRepository {
    fun save(transferDataEntity: TransferDataEntity) : TransferDataEntity
    fun findAllByShippingAccount(shippingAccount: String) : List<TransferDataEntity>
}