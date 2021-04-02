package com.kongbarber.kongbackendapi.company.shared.dto

import java.time.LocalDateTime

data class CompanyResponse(
    var _id: String? = null,
    var name: String? = null,
    var shortName: String? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null,
    var downgradePlanFree: Boolean? = null,
    var plan: Plan? = null,
    var planOld: Plan? = null,
    var services: List<Service>? = null
) {
    data class Plan(
        var payment: Payment? = null,
        var name: String? = null,
        var amountUsers: Int? = null,
        var amountUsersAdmin: Int? = null,
        var amountUsersCommon: Int? = null,
        var maxCash: Double? = 0.0,
        var dateStarted: String? = null,
        var dateEnd: String? = null,
    )

    data class Payment(
        var price: Double = 0.0
    )

    data class Service(
        var type: String? = null,
        var price: Double? = 0.0
    )
}

