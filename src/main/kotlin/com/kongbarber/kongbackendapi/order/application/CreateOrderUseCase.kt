package com.kongbarber.kongbackendapi.order.application

import com.kongbarber.kongbackendapi.order.shared.dto.OrderRequest
import com.kongbarber.kongbackendapi.order.shared.dto.OrderResponse
import reactor.core.publisher.Mono

interface CreateOrderUseCase {
    fun execute(orderRequest: OrderRequest): Mono<OrderResponse>
}
