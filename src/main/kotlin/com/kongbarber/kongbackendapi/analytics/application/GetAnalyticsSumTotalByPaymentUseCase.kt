package com.kongbarber.kongbackendapi.analytics.application

import com.kongbarber.kongbackendapi.analytics.shared.dto.AnalyticsPaymentTypeRequest
import com.kongbarber.kongbackendapi.analytics.shared.dto.AnalyticsPaymentTypeResponse
import reactor.core.publisher.Flux

interface GetAnalyticsSumTotalByPaymentUseCase {

    fun execute(analyticsPaymentTypeRequest: AnalyticsPaymentTypeRequest ): Flux<AnalyticsPaymentTypeResponse>
}
