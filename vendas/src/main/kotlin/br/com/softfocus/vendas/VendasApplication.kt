package br.com.softfocus.vendas

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
class VendasApplication

fun main(args: Array<String>) {
	runApplication<VendasApplication>(*args)
}
