package com.kongbarber.kongbackendapi.user.application.impl

import com.kongbarber.kongbackendapi.user.application.CreateUserUseCase
import com.kongbarber.kongbackendapi.user.application.gateway.CreateUserGateway
import com.kongbarber.kongbackendapi.user.shared.dto.UserRequest
import com.kongbarber.kongbackendapi.user.shared.dto.UserResponse
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CreateUserUseCaseImpl(
    private val createUserGateway: CreateUserGateway
) : CreateUserUseCase {

    override fun execute(userRequest: UserRequest?): Mono<UserResponse> {
        return createUserGateway.save(userRequest)
    }

}