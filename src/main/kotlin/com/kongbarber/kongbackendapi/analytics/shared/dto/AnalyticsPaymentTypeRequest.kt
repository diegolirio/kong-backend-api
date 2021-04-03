package com.kongbarber.kongbackendapi.analytics.shared.dto

import java.time.LocalDate

data class AnalyticsPaymentTypeRequest(
    val companyId: String? = null,
    val dateStart: LocalDate? = null,
    val dateEnd: LocalDate? = null,
)