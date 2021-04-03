package com.kongbarber.kongbackendapi.analytics.presentation

import com.kongbarber.kongbackendapi.order.presentation.OrderApi
import com.kongbarber.kongbackendapi.order.presentation.OrderHandler
import com.kongbarber.kongbackendapi.order.shared.dto.OrderRequest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
class AnalyticsApiIntegrationTests {

    @Autowired
    private lateinit var analyticsHandler: AnalyticsHandler

    @Autowired
    private lateinit var orderHandler: OrderHandler

    @Test
    fun `test get analytics sum total by payment-type`() {

        val client2 = WebTestClient
            .bindToRouterFunction(OrderApi(orderHandler).routeOrder())
            .build()

        client2.post()
            .uri(OrderApi.ORDER_API)
            .bodyValue(
                OrderRequest(
                    paymentType = OrderRequest.PaymentType.cash,
                    total = 30.00,
                    company = "606627b33919e16f05f4b1a7",
                    date = "2021-04-02"
                )
            )
            .exchange()
            .expectStatus().isCreated

        client2.post()
            .uri(OrderApi.ORDER_API)
            .bodyValue(
                OrderRequest(
                    paymentType = OrderRequest.PaymentType.card,
                    total = 25.00,
                    company = "606627b33919e16f05f4b1a7",
                    date = "2021-04-01"
                )
            )
            .exchange()
            .expectStatus().isCreated

        val client = WebTestClient
            .bindToRouterFunction(AnalyticsApi(analyticsHandler).routeAnalytics())
            .build()

        client.get()
            .uri("${AnalyticsApi.ANALYTICS_API}/payments-type/2021-03-30/2021-04-04")
            .header("company", "606627b33919e16f05f4b1a7")
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .jsonPath("[0].paymentType").isEqualTo("cash")
            .jsonPath("[0].total").isNotEmpty
            .jsonPath("[1].paymentType").isEqualTo("card")
            .jsonPath("[1].total").isNotEmpty

    }
}