package com.kongbarber.kongbackendapi.analytics.application.gateway

import com.kongbarber.kongbackendapi.analytics.shared.dto.AnalyticsPaymentTypeRequest
import com.kongbarber.kongbackendapi.analytics.shared.dto.AnalyticsPaymentTypeResponse
import reactor.core.publisher.Flux

interface GetAnalyticsSumTotalByPaymentGateway {

    fun getSumTotalByPayment(analyticsPaymentTypeRequest: AnalyticsPaymentTypeRequest): Flux<AnalyticsPaymentTypeResponse>
}
