package com.kongbarber.kongbackendapi.company.presentation

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class CompanyApi(
    private val companyHandler: CompanyHandler
) {

    companion object { const val COMPANY_API = "/api/companies" }

    @Bean
    fun routeCompany() = router {
        (COMPANY_API and accept(MediaType.APPLICATION_JSON)).nest {
            POST("", companyHandler::createCompany)
            GET("", companyHandler::getAllCompany)
        }
    }
}
