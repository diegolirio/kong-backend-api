package com.kongbarber.kongbackendapi.user.presentation

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class UserApi {

    companion object { const val API_USERS = "/api/users" }

    @Bean
    fun route(
        userHandle: UserHandle
    ) = router {

        (API_USERS and accept(MediaType.APPLICATION_JSON)).nest {
            // GET("", userHandle::getAll)
            GET("") { userHandle.getAll() }
            POST("", userHandle::createUser)
            GET("/{_id}", userHandle::getById)
        }
    }
}
