package com.kongbarber.kongbackendapi.user.presentation

import com.kongbarber.kongbackendapi.user.application.CreateUserUseCase
import com.kongbarber.kongbackendapi.user.application.GetAllUsersUseCase
import com.kongbarber.kongbackendapi.user.application.GetByIdUseCase
import com.kongbarber.kongbackendapi.user.shared.dto.UserRequest
import com.kongbarber.kongbackendapi.user.shared.dto.UserResponse
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class UserHandle(
    private val createUserUseCase: CreateUserUseCase,
    private val getAllUsersUseCase: GetAllUsersUseCase,
    private val getByIdUserCase: GetByIdUseCase
) {

    fun createUser(request: ServerRequest): Mono<ServerResponse> {
        return request.bodyToMono(UserRequest::class.java)
            .flatMap {
                ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(createUserUseCase.execute(it), UserResponse::class.java)
            }
    }

    fun getAll() : Mono<ServerResponse> {
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(getAllUsersUseCase.execute(), UserResponse::class.java)
    }

    fun getById(serverRequest: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(
                getByIdUserCase.execute(serverRequest.pathVariable("_id")),
                UserResponse::class.java
            )
    }
}