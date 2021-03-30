package com.kongbarber.kongbackendapi.user.application

import com.kongbarber.kongbackendapi.user.application.gateway.GetAllUsersGateway
import com.kongbarber.kongbackendapi.user.shared.dto.UserResponse
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

interface GetAllUsersUseCase {
    fun execute(): Flux<UserResponse>
}

@Service
class GetAllUsersUseCaseImpl(
    private val getAllUsersGateway: GetAllUsersGateway
) : GetAllUsersUseCase {

    override fun execute(): Flux<UserResponse> = getAllUsersGateway.getAllUsers()

}