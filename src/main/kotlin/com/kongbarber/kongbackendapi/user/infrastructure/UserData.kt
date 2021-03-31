package com.kongbarber.kongbackendapi.user.infrastructure

import com.kongbarber.kongbackendapi.user.application.gateway.CreateUserGateway
import com.kongbarber.kongbackendapi.user.application.gateway.GetAllUsersGateway
import com.kongbarber.kongbackendapi.user.application.gateway.GetUserByIdGateway
import com.kongbarber.kongbackendapi.user.infrastructure.repository.User
import com.kongbarber.kongbackendapi.user.infrastructure.repository.UserRepository
import com.kongbarber.kongbackendapi.user.shared.dto.ConfigurationResponse
import com.kongbarber.kongbackendapi.user.shared.dto.UserRequest
import com.kongbarber.kongbackendapi.user.shared.dto.UserResponse
import com.kongbarber.kongbackendapi.user.shared.dto.UserTypeResponse
import com.kongbarber.kongbackendapi.user.shared.extensions.toUser
import com.kongbarber.kongbackendapi.user.shared.extensions.toUserResponse
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
class UserData(
    private val userRepository: UserRepository
) : GetAllUsersGateway, CreateUserGateway, GetUserByIdGateway {

    override fun getAllUsers(): Flux<UserResponse> =
        userRepository
            .findAll()
            .map {
                it.toUserResponse()
            }

    override fun save(userRequest: UserRequest?): Mono<UserResponse> {
        return userRepository.save(
                userRequest!!.toUser()
            ).map{
                    it.toUserResponse()
            }
    }

    override fun getById(_id: String): Mono<UserResponse> {
        return userRepository
            .findById(_id)
            .map{
                    it.toUserResponse()
            }
    }

}