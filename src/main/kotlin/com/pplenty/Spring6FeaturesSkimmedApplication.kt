package com.pplenty

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class Spring6FeaturesSkimmedApplication

fun main(args: Array<String>) {
	runApplication<Spring6FeaturesSkimmedApplication>(*args)
}
