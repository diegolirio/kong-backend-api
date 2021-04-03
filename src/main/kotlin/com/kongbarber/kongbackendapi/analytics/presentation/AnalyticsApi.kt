package com.kongbarber.kongbackendapi.analytics.presentation

import com.kongbarber.kongbackendapi.order.infrastructure.repository.Order
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class AnalyticsApi(
    private val analyticsHandler: AnalyticsHandler
) {

    companion object {
        const val ANALYTICS_API = "/api/analytics"
        const val PAYMENTS_TYPE_API = "/payments-type/{dateStart}/{dateEnd}"
    }

    @Bean
    fun routeAnalytics() = router {

        (ANALYTICS_API and accept(MediaType.APPLICATION_JSON)).nest {
            GET(PAYMENTS_TYPE_API, analyticsHandler::getAnalyticsSumTotalByPayment)
        }
    }

}