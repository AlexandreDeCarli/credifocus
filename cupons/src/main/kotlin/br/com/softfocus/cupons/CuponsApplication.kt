package br.com.softfocus.cupons

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class CuponsApplication

fun main(args: Array<String>) {
	runApplication<CuponsApplication>(*args)
}
