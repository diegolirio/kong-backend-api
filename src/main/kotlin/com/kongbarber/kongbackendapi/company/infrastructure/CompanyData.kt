package com.kongbarber.kongbackendapi.company.infrastructure

import com.kongbarber.kongbackendapi.company.application.gateway.CreateCompanyGateway
import com.kongbarber.kongbackendapi.company.application.gateway.GetAllCompaniesGateway
import com.kongbarber.kongbackendapi.company.infrastructure.repository.CompanyRepository
import com.kongbarber.kongbackendapi.company.shared.dto.CompanyRequest
import com.kongbarber.kongbackendapi.company.shared.dto.CompanyResponse
import com.kongbarber.kongbackendapi.company.shared.extesions.toCompany
import com.kongbarber.kongbackendapi.company.shared.extesions.toCompanyResponse
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class CompanyData(
    private val companyRepository: CompanyRepository
) : GetAllCompaniesGateway, CreateCompanyGateway {

    override fun getAll(): Flux<CompanyResponse> =
        companyRepository
            .findAll()
            .map {
                it.toCompanyResponse()
            }

    override fun save(companyRequest: CompanyRequest): Mono<CompanyResponse> =
        companyRepository
            .save(companyRequest.toCompany())
            .map {
                it.toCompanyResponse()
            }
}