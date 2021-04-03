package com.kongbarber.kongbackendapi.order.application.impl

import com.kongbarber.kongbackendapi.order.application.CreateOrderUseCase
import com.kongbarber.kongbackendapi.order.application.gateway.CreateOrderGateway
import com.kongbarber.kongbackendapi.order.shared.dto.OrderRequest
import com.kongbarber.kongbackendapi.order.shared.dto.OrderResponse
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CreateOrderUseCaseImpl(
    private val createOrderGateway: CreateOrderGateway
): CreateOrderUseCase {

    override fun execute(orderRequest: OrderRequest): Mono<OrderResponse> =
        createOrderGateway.save(orderRequest)
}