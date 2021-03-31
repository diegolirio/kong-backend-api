package com.kongbarber.kongbackendapi.user.application.gateway

import com.kongbarber.kongbackendapi.user.shared.dto.UserResponse
import reactor.core.publisher.Mono

interface GetUserByIdGateway {
    fun getById(_id: String): Mono<UserResponse>
}
