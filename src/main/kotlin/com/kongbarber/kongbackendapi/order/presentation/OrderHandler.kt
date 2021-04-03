package com.kongbarber.kongbackendapi.order.presentation

import com.kongbarber.kongbackendapi.order.application.CreateOrderUseCase
import com.kongbarber.kongbackendapi.order.application.GetAllOrdersUseCase
import com.kongbarber.kongbackendapi.order.shared.dto.OrderRequest
import com.kongbarber.kongbackendapi.order.shared.dto.OrderResponse
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.net.URI

@Component
class OrderHandler(
    private val getAllOrdersUseCase: GetAllOrdersUseCase,
    private val createOrderUseCase: CreateOrderUseCase
) {
    fun getAll(serverRequest: ServerRequest): Mono<ServerResponse> =
        ServerResponse.ok()
            .body(getAllOrdersUseCase.execute(), OrderResponse::class.java)

    fun create(serverRequest: ServerRequest): Mono<ServerResponse> =
        serverRequest.bodyToMono(OrderRequest::class.java)
            .flatMap {
                ServerResponse.created(URI("/api/orders"))
                    .body(createOrderUseCase.execute(it), OrderResponse::class.java)
            }
}
