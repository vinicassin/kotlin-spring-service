package br.com.kotlinspringservice.application.web.controllers

import br.com.kotlinspringservice.application.web.entities.requests.TransferRequest
import br.com.kotlinspringservice.application.web.entities.requests.toDomain
import br.com.kotlinspringservice.application.web.entities.requests.validateRequestParams
import br.com.kotlinspringservice.application.web.entities.responses.TransferResponse
import br.com.kotlinspringservice.domain.services.TransferService
import br.com.kotlinspringservice.domain.toResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transfer")
class TransferController {

    @Autowired
    private lateinit var service: TransferService

    @PostMapping
    fun post(@RequestBody request: TransferRequest): ResponseEntity<TransferResponse> {
        validateRequestParams(request)

        val domain = request.toDomain()
        val response = service.createTransfer(domain)

        return ResponseEntity(response.toResponse(), HttpStatus.CREATED)
    }

    @GetMapping("/{shippingAccount}")
    fun findByShippingAccount(
        @PathVariable("shippingAccount") shippingAccount: String
    ): ResponseEntity<List<TransferResponse>> {

        val response = service.findByShippingAccount(shippingAccount).map { transferData ->
            transferData.toResponse()
        }

        return ResponseEntity(response, HttpStatus.ACCEPTED)
    }
}
