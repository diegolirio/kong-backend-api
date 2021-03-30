package com.kongbarber.kongbackendapi.user.application

import com.kongbarber.kongbackendapi.user.application.gateway.CreateUserGateway
import com.kongbarber.kongbackendapi.user.shared.dto.UserRequest
import com.kongbarber.kongbackendapi.user.shared.dto.UserResponse
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

interface CreateUserUseCase {
    fun execute(userRequest: UserRequest?): Mono<UserResponse>
}

@Service
class CreateUserUseCaseImpl(
    private val createUserGateway: CreateUserGateway
) : CreateUserUseCase {

    override fun execute(userRequest: UserRequest?): Mono<UserResponse> {
        return createUserGateway.save(userRequest)
    }

}