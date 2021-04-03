package com.kongbarber.kongbackendapi.analytics.infrastructure.repository.paymenttype

import com.kongbarber.kongbackendapi.analytics.infrastructure.repository.paymenttype.document.AggreagationByPaymentType
import reactor.core.publisher.Flux
import java.time.LocalDate

interface GetSumTotalByPaymentRepository {

    fun getSumTotalByPayment(companyId: String?, start: LocalDate?, end: LocalDate?): Flux<AggreagationByPaymentType>
}
