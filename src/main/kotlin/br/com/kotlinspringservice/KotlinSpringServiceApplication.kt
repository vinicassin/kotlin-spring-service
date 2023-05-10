package br.com.kotlinspringservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringServiceApplication

fun main(args: Array<String>) {
	runApplication<KotlinSpringServiceApplication>(*args)
}
