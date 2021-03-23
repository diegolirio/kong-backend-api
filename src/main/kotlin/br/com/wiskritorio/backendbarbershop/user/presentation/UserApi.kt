package br.com.wiskritorio.backendbarbershop.user.presentation

import br.com.wiskritorio.backendbarbershop.user.application.getall.GetAllUsersUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.router

@Configuration
class UserApi {

    @Bean
    fun route(getAllUsersUseCase: GetAllUsersUseCase) = router {
        ("/api/users" and accept(MediaType.APPLICATION_JSON)).nest {
            GET("") {
                ok().body(getAllUsersUseCase.execute())
            }
        }
    }
}