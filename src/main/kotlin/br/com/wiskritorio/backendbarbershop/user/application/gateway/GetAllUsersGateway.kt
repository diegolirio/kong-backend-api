package br.com.wiskritorio.backendbarbershop.user.application.gateway

import br.com.wiskritorio.backendbarbershop.user.shared.dto.UserResponse
import reactor.core.publisher.Flux

interface GetAllUsersGateway {
    fun getAllUsers(): Flux<UserResponse>
}