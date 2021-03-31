package com.kongbarber.kongbackendapi.user.application.impl

import com.kongbarber.kongbackendapi.user.application.GetByIdUseCase
import com.kongbarber.kongbackendapi.user.application.gateway.GetUserByIdGateway
import com.kongbarber.kongbackendapi.user.shared.dto.UserResponse
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class GetByIdUseCaseImpl(
    private val getByIdUseCaseImpl: GetUserByIdGateway
) : GetByIdUseCase {
    override fun execute(_id: String): Mono<UserResponse> {
        return getByIdUseCaseImpl.getById(_id)
    }
}