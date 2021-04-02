package com.kongbarber.kongbackendapi.order.application.impl

import com.kongbarber.kongbackendapi.order.application.gateway.GetAllOrdersGateway
import com.kongbarber.kongbackendapi.order.application.GetAllOrdersUseCase
import com.kongbarber.kongbackendapi.order.shared.dto.OrderResponse
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class GetAllOrdersUseCaseImpl(
    private val getAllOrdersGateway: GetAllOrdersGateway
): GetAllOrdersUseCase {
    override fun execute(): Flux<OrderResponse> =
        getAllOrdersGateway.getAll()
}