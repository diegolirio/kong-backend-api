package com.kongbarber.kongbackendapi.order.application.gateway

import com.kongbarber.kongbackendapi.order.shared.dto.OrderResponse
import reactor.core.publisher.Flux

interface GetAllOrdersGateway {
    fun getAll(): Flux<OrderResponse>
}
