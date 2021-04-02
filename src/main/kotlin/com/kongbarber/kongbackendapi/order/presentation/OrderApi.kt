package com.kongbarber.kongbackendapi.order.presentation

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class OrderApi(
    private val orderHandler: OrderHandler
) {
    companion object { const val ORDER_API = "/api/orders" }

    @Bean
    fun routeOrder() = router {
        (ORDER_API and accept(MediaType.APPLICATION_JSON)).nest {
            GET("", orderHandler::getAll)
        }
    }

}
