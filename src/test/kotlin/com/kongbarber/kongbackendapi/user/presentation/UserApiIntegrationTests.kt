package com.kongbarber.kongbackendapi.user.presentation

import com.kongbarber.kongbackendapi.user.shared.dto.UserRequest
import com.kongbarber.kongbackendapi.user.shared.dto.UserResponse
import com.kongbarber.kongbackendapi.user.shared.dto.UserTypeResponse
import org.hamcrest.Matchers
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.FluxExchangeResult
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@ExtendWith(SpringExtension::class)
class UserApiIntegrationTests {

    //    @BeforeAll
    //    fun setUp() {
    //        client = WebTestClient.bindToRouterFunction(config.route()).build()
    //    }

    //    @BeforeAll
    //    fun initClient() {
    //        client = WebTestClient.bindToServer().baseUrl("http://localhost:8080").build();
    //    }

    var userRequest: UserRequest? = null

    @Autowired
    private lateinit var userHandle: UserHandle

    @BeforeAll
    fun beforeAll() {
        userRequest = UserRequest(
            name = "Diego",
            username = "diego",
            email = "diegolirio.dl@gmail.com",
            phone_number = "(11) 96140-9798"
        )
    }

    @Test
    fun `test get all users`() {
        val client = WebTestClient.bindToRouterFunction(UserApi().route(userHandle)).build()

        client.post()
            .uri("/api/users")
            .bodyValue(userRequest!!)
            .exchange()
            .expectStatus().isOk
            .expectBody()

        client.get()
            .uri("/api/users")
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .jsonPath("[0]._id").isNotEmpty
            .jsonPath("[0].name").isEqualTo(userRequest?.name!!)
    }

    @Test
    fun `get by id - valid fields generated automatic`() {
        val client = WebTestClient.bindToRouterFunction(UserApi().route(userHandle)).build()

        val userValuesObrigatorios =
            UserRequest(
                name = "Diego",
                username = "diego",
                email = "diegolirio.dl@gmail.com",
                phone_number = "(11) 96140-9798",
                password = "123321"
            )

//                "username": "diego", => *
//                "name": "Diego", => *
//                "password": "$2a$10$VQgfFIUIC1fHGpP1s1Kfzeyaq6qfwSxbTqyjAbaSpyvv3/RxmuEOa", => * RETURN DEFAULT
//                "createdAt": "2021-02-02T22:47:49.763Z", => RETURN DEFAULT
//                "updatedAt": "2021-03-29T23:19:54.414Z", => RETURN DEFAULT
//                "__v": 0, => ?
//                "email": "diego@diego.com", => NO
//                "phone_number": "11961409798", => *
//                "company": "605a74946d4dc50008cb12f1", => *
//                "device": "Mozilla/5.0 (iPhone; CPU iPhone OS 14_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0.3 Mobile/15E148 Safari/604.1" => NO
//            }

        val result: FluxExchangeResult<UserResponse> = client.post()
            .uri("/api/users")
            .bodyValue(userValuesObrigatorios)
            .exchange()
            .returnResult(UserResponse::class.java)

        // var httpStatus = result.status
        // var responseHeaders = result.responseHeaders
        val responseBody = result.responseBody.blockFirst()

        println(responseBody)

        client.get()
            .uri("${UserApi.API_USERS}/${responseBody?._id}")
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .json("{}")
            .jsonPath("$._id").isEqualTo(responseBody?._id!!)
            .jsonPath("$.username").isEqualTo(responseBody.username!!)
            .jsonPath("$.name").isEqualTo(responseBody.name!!)
            .jsonPath("$.email").isEqualTo(responseBody.email!!)
            .jsonPath("$.phone_number").isEqualTo(responseBody.phone_number!!)
            .jsonPath("$.configuration.table").isEqualTo("mobile")
            .jsonPath("$.disabled").isEqualTo(false)
            .jsonPath("$.type").isEqualTo(UserTypeResponse.hairdresser.name)
            .jsonPath("$.ratedUs").isEqualTo(false)
            //.jsonPath("$.password", userValuesObrigatorios.password!!)
            //.jsonPath("$.company").isNotEmpty


    }
}
