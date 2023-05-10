package br.com.kotlinspringservice.resources.repositories.impl

import br.com.kotlinspringservice.application.exceptions.DatabaseException
import br.com.kotlinspringservice.domain.repositories.TransferRepository
import br.com.kotlinspringservice.resources.repositories.TransferDataEntity
import br.com.kotlinspringservice.resources.repositories.TransferRepositoryJPA
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class TransferSql: TransferRepository {

    @Autowired
    private lateinit var repository: TransferRepositoryJPA

    override fun save(transferDataEntity: TransferDataEntity) : TransferDataEntity {
        try {
            return repository.save(transferDataEntity)
        } catch (ex: Exception) {
            throw DatabaseException("Error when try create a new transfer in DB.", ex)
        }
    }

    override fun findAllByShippingAccount(shippingAccount: String): List<TransferDataEntity> {
        return repository.findAllByShippingAccount(shippingAccount)
    }

}
