package com.kongbarber.kongbackendapi.analytics.presentation

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
class AnalyticsApiIntegrationTests {

    @Autowired
    private lateinit var getAllPaymentsType: GetAllPaymentsType

    @Test
    fun `test get`() {
        val client = WebTestClient
            .bindToRouterFunction(
                AnalyticsApi(getAllPaymentsType).routeAnalytics()
            )
            .build()

        client.get()
            .uri("/api/analytics")
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .jsonPath("[0]").isEqualTo(15280)
            .jsonPath("[1]").isEqualTo(25400)
    }
}