package com.kongbarber.kongbackendapi.analytics.shared.dto

data class AnalyticsPaymentTypeResponse(
    var paymentType: String? = null,
    var total: Double? = 0.0
)