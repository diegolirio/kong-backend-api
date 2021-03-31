package com.kongbarber.kongbackendapi.user.application

import com.kongbarber.kongbackendapi.user.shared.dto.UserResponse
import reactor.core.publisher.Flux

interface GetAllUsersUseCase {
    fun execute(): Flux<UserResponse>
}

