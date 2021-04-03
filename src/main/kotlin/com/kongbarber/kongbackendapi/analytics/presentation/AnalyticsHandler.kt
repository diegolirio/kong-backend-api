package com.kongbarber.kongbackendapi.analytics.presentation

import com.kongbarber.kongbackendapi.analytics.application.GetAnalyticsSumTotalByPaymentUseCase
import com.kongbarber.kongbackendapi.analytics.shared.dto.AnalyticsPaymentTypeRequest
import com.kongbarber.kongbackendapi.analytics.shared.dto.AnalyticsPaymentTypeResponse
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.time.LocalDate

@Component
class AnalyticsHandler(
    private val getAnalyticsSumTotalByPaymentUseCase: GetAnalyticsSumTotalByPaymentUseCase
) {

    fun getAnalyticsSumTotalByPayment(serverRequest: ServerRequest): Mono<ServerResponse> =
        ServerResponse.ok()
            .body(
                getAnalyticsSumTotalByPaymentUseCase.execute(
                    AnalyticsPaymentTypeRequest(
                        companyId = serverRequest.headers().header("company").let { it[0] },
                        dateStart = LocalDate.parse(serverRequest.pathVariable("dateStart")),
                        dateEnd = LocalDate.parse(serverRequest.pathVariable("dateEnd"))
                    )
                ),
                AnalyticsPaymentTypeResponse::class.java
            )
}
