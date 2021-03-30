package com.kongbarber.kongbackendapi.user.infrastructure

import com.kongbarber.kongbackendapi.user.application.gateway.CreateUserGateway
import com.kongbarber.kongbackendapi.user.application.gateway.GetAllUsersGateway
import com.kongbarber.kongbackendapi.user.shared.dto.UserRequest
import com.kongbarber.kongbackendapi.user.shared.dto.UserResponse
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
class UserData(
    private val userRepository: UserRepository
) : GetAllUsersGateway, CreateUserGateway {

    override fun getAllUsers(): Flux<UserResponse> =
        userRepository.findAll().map {
            UserResponse(
                _id = it._id,
                username = it.username,
                name = it.name,
                email = it.email,
                phone_number = it.phone_number
            )
    }

    override fun save(userRequest: UserRequest?): Mono<UserResponse> {
        return userRepository.save(
            User(
                name = userRequest?.name,
                username = userRequest?.username,
                email = userRequest?.email,
                phone_number = userRequest?.phone_number
            )
        ).map {
            UserResponse(
                _id = it._id,
                name = it.name,
                email = it.email,
                phone_number = it.phone_number
            )
        }

    }

}