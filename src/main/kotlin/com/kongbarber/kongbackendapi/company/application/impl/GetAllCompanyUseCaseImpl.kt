package com.kongbarber.kongbackendapi.company.application.impl

import com.kongbarber.kongbackendapi.company.application.GetAllCompanyUseCase
import com.kongbarber.kongbackendapi.company.application.gateway.GetAllCompaniesGateway
import com.kongbarber.kongbackendapi.company.shared.dto.CompanyResponse
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class GetAllCompanyUseCaseImpl(
    private val getAllCompaniesGateway: GetAllCompaniesGateway
) : GetAllCompanyUseCase {

    override fun execute(): Flux<CompanyResponse> =
        getAllCompaniesGateway.getAll()

}