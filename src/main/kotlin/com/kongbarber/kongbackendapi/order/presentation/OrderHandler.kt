package com.kongbarber.kongbackendapi.order.presentation

import com.kongbarber.kongbackendapi.order.application.GetAllOrdersUseCase
import com.kongbarber.kongbackendapi.order.shared.dto.OrderResponse
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class OrderHandler(
    private val getAllOrdersUseCase: GetAllOrdersUseCase
) {
    fun getAll(serverRequest: ServerRequest): Mono<ServerResponse> =
        ServerResponse.ok()
            .body(getAllOrdersUseCase.execute(), OrderResponse::class.java)
}
