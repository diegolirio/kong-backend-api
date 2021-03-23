package br.com.wiskritorio.backendbarbershop.user.application.getall

import br.com.wiskritorio.backendbarbershop.user.application.gateway.GetAllUsersGateway
import br.com.wiskritorio.backendbarbershop.user.shared.dto.UserResponse
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