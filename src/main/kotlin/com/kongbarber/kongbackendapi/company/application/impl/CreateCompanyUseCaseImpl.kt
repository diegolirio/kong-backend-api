package com.kongbarber.kongbackendapi.company.application.impl

import com.kongbarber.kongbackendapi.company.application.CreateCompanyUseCase
import com.kongbarber.kongbackendapi.company.application.gateway.CreateCompanyGateway
import com.kongbarber.kongbackendapi.company.shared.dto.CompanyRequest
import com.kongbarber.kongbackendapi.company.shared.dto.CompanyResponse
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CreateCompanyUseCaseImpl(
    private val createCompanyGateway: CreateCompanyGateway
): CreateCompanyUseCase {

    override fun execute(companyRequest: CompanyRequest): Mono<CompanyResponse> =
        createCompanyGateway.save(companyRequest)
}