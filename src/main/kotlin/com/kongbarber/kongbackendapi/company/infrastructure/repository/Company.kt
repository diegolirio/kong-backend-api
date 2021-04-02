package com.kongbarber.kongbackendapi.company.infrastructure.repository

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(value = "companies")
data class Company(
    @Id var _id: String? = null,
    var name: String? = null,
    var shortName: String? = null,
    var downgradePlanFree: Boolean = false,
    @CreatedDate var createdAt: LocalDateTime = LocalDateTime.now(),
    @LastModifiedDate var updatedAt: LocalDateTime = LocalDateTime.now(),
    var plan: Plan? = null,
    var planOld: Plan? = null,
    var services: List<Service>? = null,
)

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