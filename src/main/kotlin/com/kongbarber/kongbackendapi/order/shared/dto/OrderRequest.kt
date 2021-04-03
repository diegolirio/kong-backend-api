package com.kongbarber.kongbackendapi.order.shared.dto

import org.bson.types.ObjectId
import java.time.LocalDateTime

data class OrderRequest(
    var _id: String? = null,
    var paymentType: PaymentType? = null,
    var services: List<Service>? = null,
    var total: Double? = null,
    var date: String? = null,
    var user: User? = null,
    var customer: Customer? = null,
    var company: String? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null,
) {

    enum class PaymentType(var type: String) {
        cash("cash"),
        card("card")
    }

    data class Service(
        var type: String? = null,
        var price: Double? = 0.0
    )


    data class User(
        var _id: ObjectId? = null,
        var name: String? = null,
        var username: String? = null,
    )

    data class Customer(
        var name: String? = null,
        var phone_number: String? = null
    )
}