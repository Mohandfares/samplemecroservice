package com.dz.mecroservice.samplemecroservice

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
@OpenAPIDefinition(info = Info(title = "blog API", version = "1.0.0", description = ""))
class SamplemecroserviceApplication

fun main(args: Array<String>) {
	runApplication<SamplemecroserviceApplication>(*args)
}
