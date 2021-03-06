package com.kongbarber.kongbackendapi.user.application

import com.kongbarber.kongbackendapi.user.shared.dto.UserRequest
import com.kongbarber.kongbackendapi.user.shared.dto.UserResponse
import reactor.core.publisher.Mono

interface CreateUserUseCase {
    fun execute(userRequest: UserRequest?): Mono<UserResponse>
}

