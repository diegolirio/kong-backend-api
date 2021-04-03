package com.kongbarber.kongbackendapi.order.shared.extensions

import com.kongbarber.kongbackendapi.order.infrastructure.repository.Order
import com.kongbarber.kongbackendapi.order.shared.dto.OrderResponse

fun Order.toOrderResponse(): OrderResponse =
    OrderResponse(
        _id = this._id,
        paymentType = OrderResponse.PaymentType.valueOf(this.paymentType.name),
        services =  services?.let { it.toServicesResponse() ?: null },
        total = this.total,
        date = this.date,
        user = this.user!!.toUserResponse(),
        customer = this.customer!!.toCustomerResponse(),
        company = this.company.toString(),
        createdAt = this.createdAt,
        updatedAt = this.updatedAt
    )

fun Order.Service.toServiceResponse(): OrderResponse.Service =
    OrderResponse.Service(
        type = this.type,
        price = this.price
    )

fun List<Order.Service>.toServicesResponse(): List<OrderResponse.Service> =
    this.map { it.toServiceResponse() }

fun Order.User.toUserResponse(): OrderResponse.User =
    OrderResponse.User(
        _id = this._id,
        name = this.name,
        username = this.username
    )

fun Order.Customer.toCustomerResponse(): OrderResponse.Customer =
    OrderResponse.Customer(
        name = this.name,
        phone_number = this.phone_number
    )