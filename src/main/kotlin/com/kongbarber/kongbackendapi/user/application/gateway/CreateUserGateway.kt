package com.kongbarber.kongbackendapi.user.application.gateway

import com.kongbarber.kongbackendapi.user.shared.dto.UserRequest
import com.kongbarber.kongbackendapi.user.shared.dto.UserResponse
import reactor.core.publisher.Mono

interface CreateUserGateway {
    fun save(userRequest: UserRequest?): Mono<UserResponse>
}