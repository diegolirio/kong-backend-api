package com.kongbarber.kongbackendapi.company.infrastructure

import com.kongbarber.kongbackendapi.company.application.GetAllCompaniesGateway
import com.kongbarber.kongbackendapi.company.infrastructure.repository.CompanyRepository
import com.kongbarber.kongbackendapi.user.shared.dto.CompanyResponse
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class CompanyData(
    private val companyRepository: CompanyRepository
) : GetAllCompaniesGateway {

    override fun getAll(): Flux<CompanyResponse> {
        return companyRepository.findAll()
            .map {
                CompanyResponse(_id = it._id, name = it.name)
            }
    }
}