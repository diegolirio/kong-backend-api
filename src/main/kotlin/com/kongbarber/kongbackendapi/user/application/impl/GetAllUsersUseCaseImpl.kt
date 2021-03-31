package com.kongbarber.kongbackendapi.user.application.impl

import com.kongbarber.kongbackendapi.user.application.GetAllUsersUseCase
import com.kongbarber.kongbackendapi.user.application.gateway.GetAllUsersGateway
import com.kongbarber.kongbackendapi.user.shared.dto.UserResponse
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class GetAllUsersUseCaseImpl(
    private val getAllUsersGateway: GetAllUsersGateway
) : GetAllUsersUseCase {

    override fun execute(): Flux<UserResponse> = getAllUsersGateway.getAllUsers()

}