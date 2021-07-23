package com.dz.mecroservice.samplemecroservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
class SamplemecroserviceApplication

fun main(args: Array<String>) {
	runApplication<SamplemecroserviceApplication>(*args)
}
