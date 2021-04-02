package com.kongbarber.kongbackendapi.order.shared.dto

data class OrderResponse(
    var _id: String? = null,
    var paymentType: PaymentType? = null,
    var services: List<Service>? = null
) {

    enum class PaymentType(var type: String) {
        cash("cash"),
        card("card")
    }

    data class Service(
        var type: String? = null,
        var price: Double? = 0.0
    )
}