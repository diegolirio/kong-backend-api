package com.kongbarber.kongbackendapi.analytics.application.impl

import com.kongbarber.kongbackendapi.analytics.application.GetAnalyticsSumTotalByPaymentUseCase
import com.kongbarber.kongbackendapi.analytics.application.gateway.GetAnalyticsSumTotalByPaymentGateway
import com.kongbarber.kongbackendapi.analytics.shared.dto.AnalyticsPaymentTypeRequest
import com.kongbarber.kongbackendapi.analytics.shared.dto.AnalyticsPaymentTypeResponse
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class GetAnalyticsSumTotalByPaymentUseCaseImpl(
    private val getAnalyticsSumTotalByPayment: GetAnalyticsSumTotalByPaymentGateway
) : GetAnalyticsSumTotalByPaymentUseCase {

    override fun execute(analyticsPaymentTypeRequest: AnalyticsPaymentTypeRequest): Flux<AnalyticsPaymentTypeResponse> =
        getAnalyticsSumTotalByPayment.getSumTotalByPayment(analyticsPaymentTypeRequest)

}