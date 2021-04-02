package com.kongbarber.kongbackendapi.order.infrastructure.repository

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document("orders")
data class Order(
    @Id var _id: String? = null,
    var paymentType: PaymentType = PaymentType.cash,
    var services: List<Service>? = null,
    var total: Double? = null,
    var date: String? = null,
    var user: User? = null,
    var customer: Customer? = null,
    var company: ObjectId? = null,
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
        var name: String? = null
    )
}