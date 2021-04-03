package com.kongbarber.kongbackendapi.order.infrastructure

import com.kongbarber.kongbackendapi.order.application.gateway.CreateOrderGateway
import com.kongbarber.kongbackendapi.order.application.gateway.GetAllOrdersGateway
import com.kongbarber.kongbackendapi.order.infrastructure.repository.Order
import com.kongbarber.kongbackendapi.order.infrastructure.repository.OrderRepository
import com.kongbarber.kongbackendapi.order.shared.dto.OrderRequest
import com.kongbarber.kongbackendapi.order.shared.dto.OrderResponse
import com.kongbarber.kongbackendapi.order.shared.extensions.toOrderResponse
import org.bson.types.ObjectId
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class OrderData(
    private val orderRepository: OrderRepository
) : GetAllOrdersGateway, CreateOrderGateway {

    override fun getAll(): Flux<OrderResponse> =
        orderRepository
            .findAll()
            .map { it.toOrderResponse() }

    override fun save(orderRequest: OrderRequest): Mono<OrderResponse> =
        orderRepository.save(
            Order(
                company = ObjectId(orderRequest.company),
                total = orderRequest.total,
                paymentType = Order.PaymentType.valueOf(orderRequest.paymentType!!.name),
                date = orderRequest.date
            )
        ).map {
            OrderResponse(
                _id = it._id,
                company = it.company.toString(),
                total = it.total,
                paymentType = OrderResponse.PaymentType.valueOf(it.paymentType.name),
                date = it.date
            )
        }

}