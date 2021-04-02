package com.kongbarber.kongbackendapi.order.infrastructure

import com.kongbarber.kongbackendapi.order.application.gateway.GetAllOrdersGateway
import com.kongbarber.kongbackendapi.order.infrastructure.repository.OrderRepository
import com.kongbarber.kongbackendapi.order.shared.dto.OrderResponse
import com.kongbarber.kongbackendapi.order.shared.extensions.toOrderResponse
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class OrderData(
    private val orderRepository: OrderRepository
) : GetAllOrdersGateway {

    override fun getAll(): Flux<OrderResponse> =
        orderRepository
            .findAll()
            .map { it.toOrderResponse() }

}