package com.kongbarber.kongbackendapi.order.application.gateway

import com.kongbarber.kongbackendapi.order.shared.dto.OrderRequest
import com.kongbarber.kongbackendapi.order.shared.dto.OrderResponse
import reactor.core.publisher.Mono

interface CreateOrderGateway {
    fun save(orderRequest: OrderRequest): Mono<OrderResponse>
}
