package com.kongbarber.kongbackendapi.user.application.gateway

import com.kongbarber.kongbackendapi.user.shared.dto.UserResponse
import reactor.core.publisher.Flux

interface GetAllUsersGateway {
    fun getAllUsers(): Flux<UserResponse>
}