package com.kongbarber.kongbackendapi.company.application

import com.kongbarber.kongbackendapi.user.shared.dto.CompanyResponse
import reactor.core.publisher.Flux

interface GetAllCompaniesGateway {
    fun getAll(): Flux<CompanyResponse>
}