package com.kongbarber.kongbackendapi.company.presentation

import com.kongbarber.kongbackendapi.company.shared.dto.CompanyRequest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
class CompanyApiIntegrationTests {

    @Autowired
    private lateinit var companyHandler: CompanyHandler

    @Test
    fun `test create new company`() {

        val client = WebTestClient
            .bindToRouterFunction(CompanyApi(companyHandler).routeCompany())
            .build()

        val companyRequest = CompanyRequest(
            name = "Lirio Tech Company SA",
            shortName = "Lirio Tech"
        )

        client.post()
            .uri(CompanyApi.COMPANY_API)
            .bodyValue(companyRequest)
            .exchange()
            .expectBody()
            .json("{}")
            .jsonPath("$._id").isNotEmpty
            .jsonPath("$.name").isEqualTo(companyRequest.name!!)
            .jsonPath("$.shortName").isEqualTo(companyRequest.shortName!!)
            .jsonPath("$.createAt").isNotEmpty
    }
}