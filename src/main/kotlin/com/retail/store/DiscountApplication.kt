package com.retail.store

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableSwagger2
@EnableWebMvc
@SpringBootApplication
class DiscountApplication

fun main(args: Array<String>) {
    runApplication<DiscountApplication>(*args)
}
