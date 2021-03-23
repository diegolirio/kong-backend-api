package br.com.wiskritorio.backendbarbershop.user.infrastructure

import br.com.wiskritorio.backendbarbershop.user.application.gateway.GetAllUsersGateway
import br.com.wiskritorio.backendbarbershop.user.shared.dto.UserResponse
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
class UserRepository : GetAllUsersGateway {
    override fun getAllUsers(): Flux<UserResponse> {
        return Flux.just(UserResponse(_id = "as3swd658f4vdhg", username = "diegolirio"))
    }
}