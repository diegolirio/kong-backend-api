package com.kongbarber.kongbackendapi.user.presentation

import com.kongbarber.kongbackendapi.user.shared.dto.UserRequest
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
//@ExtendWith(SpringExtension::class)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserApiIntegrationTests() {

    //    @Autowired
    //    private lateinit var client: WebTestClient

    //    @BeforeAll
    //    fun setUp() {
    //        client = WebTestClient.bindToRouterFunction(config.route()).build()
    //    }


    //    @BeforeAll
    //    fun initClient() {
    //        client = WebTestClient.bindToServer().baseUrl("http://localhost:8080").build();
    //    }

    @Autowired
    private lateinit var userHandle: UserHandle

    @Test
    fun `test get all users`() {
        val client = WebTestClient.bindToRouterFunction(UserApi().route(userHandle)).build()
        val userRequest = UserRequest(
            name = "Diego",
            username = "diegolirio",
            email = "diegolirio.dl@gmail.com",
            phone_number = "(11) 96140-9798"
        )

        client.post()
            .uri("/api/users")
            .bodyValue(userRequest)
            .exchange()
            .expectStatus().isOk
            .expectBody()

        client.get()
            .uri("/api/users")
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .jsonPath("[0]._id").isNotEmpty
            .jsonPath("[0].name").isEqualTo(userRequest.name!!)
    }

    @Test
    fun `get by id`() {
        val client = WebTestClient.bindToRouterFunction(UserApi().route(userHandle)).build()
        client.get()
            .uri("${UserApi.API_USERS}/123456")
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .json("{}")
    }
}
