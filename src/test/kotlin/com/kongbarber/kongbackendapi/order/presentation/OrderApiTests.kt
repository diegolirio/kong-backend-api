package com.kongbarber.kongbackendapi.order.presentation

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
class OrderApiTests {

    @Autowired
    private lateinit var orderHandler: OrderHandler

    @Test
    fun `test get all orders`() {
        val client = WebTestClient
            .bindToRouterFunction(OrderApi(orderHandler).routeOrder())
            .build()

        client.get()
            .uri(OrderApi.ORDER_API)
            .exchange()
            .expectBody()
            .jsonPath("$._id")
    }
}