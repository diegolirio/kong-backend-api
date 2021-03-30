package com.kongbarber.kongbackendapi.analytics.presentation

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Flux

@Configuration
class AnalyticsApi(private val getAllPaymentsType: GetAllPaymentsType) {

    @Bean
    fun routeAnalytics() = router {

        ("/api/analytics" and accept(MediaType.APPLICATION_JSON)).nest {
            GET("") { ok().body(getAllPaymentsType.execute()) }
        }
    }

}

@Service
class GetAllPaymentsType {

    fun execute(): Flux<Int> {
        return Flux.just(15280, 25400)
    }
}