package com.kongbarber.kongbackendapi.order.shared.extensions

import com.kongbarber.kongbackendapi.order.infrastructure.repository.Order
import com.kongbarber.kongbackendapi.order.shared.dto.OrderResponse

fun Order.toOrderResponse(): OrderResponse =
    OrderResponse(
        _id = this._id,
        paymentType = OrderResponse.PaymentType.valueOf(this.paymentType!!.name),
        services =  services?.let { it.toServicesResponse() ?: null }
    )

fun Order.Service.toServiceResponse(): OrderResponse.Service =
    OrderResponse.Service(
        type = this.type,
        price = this.price
    )

fun List<Order.Service>.toServicesResponse(): List<OrderResponse.Service> =
    this.map { it.toServiceResponse() }