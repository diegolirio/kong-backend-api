package com.kongbarber.kongbackendapi.analytics.infrastructure

import com.kongbarber.kongbackendapi.analytics.application.gateway.GetAnalyticsSumTotalByPaymentGateway
import com.kongbarber.kongbackendapi.analytics.infrastructure.repository.paymenttype.GetSumTotalByPaymentRepository
import com.kongbarber.kongbackendapi.analytics.shared.dto.AnalyticsPaymentTypeRequest
import com.kongbarber.kongbackendapi.analytics.shared.dto.AnalyticsPaymentTypeResponse
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import java.time.LocalDate

@Component
class AnalyticsData(
    private val getSumTotalByPaymentRepository: GetSumTotalByPaymentRepository
): GetAnalyticsSumTotalByPaymentGateway {
    override fun getSumTotalByPayment(analyticsPaymentTypeRequest: AnalyticsPaymentTypeRequest): Flux<AnalyticsPaymentTypeResponse> {
        return getSumTotalByPaymentRepository
            .getSumTotalByPayment(
                analyticsPaymentTypeRequest.companyId,
                analyticsPaymentTypeRequest.dateStart,
                analyticsPaymentTypeRequest.dateEnd
            )
            .map {
                AnalyticsPaymentTypeResponse(
                    total = it.totalByPayment,
                    paymentType = it._id
                )
            }
    }
}