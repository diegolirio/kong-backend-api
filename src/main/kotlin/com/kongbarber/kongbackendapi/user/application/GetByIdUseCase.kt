package com.kongbarber.kongbackendapi.user.application

import com.kongbarber.kongbackendapi.user.shared.dto.UserResponse
import reactor.core.publisher.Mono

interface GetByIdUseCase {
    fun execute(_id: String): Mono<UserResponse>
}

