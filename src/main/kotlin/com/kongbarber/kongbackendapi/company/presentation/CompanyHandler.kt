package com.kongbarber.kongbackendapi.company.presentation

import com.kongbarber.kongbackendapi.company.application.CreateCompanyUseCase
import com.kongbarber.kongbackendapi.company.application.GetAllCompanyUseCase
import com.kongbarber.kongbackendapi.company.shared.dto.CompanyRequest
import com.kongbarber.kongbackendapi.company.shared.dto.CompanyResponse
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class CompanyHandler(
    private val createCompanyUseCase: CreateCompanyUseCase,
    private val getAllCompanyUseCase: GetAllCompanyUseCase
) {

    fun createCompany(request: ServerRequest): Mono<ServerResponse> =
        request.bodyToMono(CompanyRequest::class.java)
            .flatMap {
                ServerResponse.ok()
                    .body(createCompanyUseCase.execute(it), CompanyResponse::class.java)
            }

    fun getAllCompany(request: ServerRequest): Mono<ServerResponse> =
        ServerResponse.ok()
            .body(getAllCompanyUseCase.execute(), CompanyResponse::class.java)

}
