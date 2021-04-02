package com.kongbarber.kongbackendapi.order.application

import com.kongbarber.kongbackendapi.order.shared.dto.OrderResponse
import reactor.core.publisher.Flux

interface GetAllOrdersUseCase {
    fun execute(): Flux<OrderResponse>
}
