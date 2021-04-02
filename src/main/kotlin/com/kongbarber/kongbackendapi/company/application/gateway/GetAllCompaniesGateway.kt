package com.kongbarber.kongbackendapi.company.application.gateway

import com.kongbarber.kongbackendapi.company.shared.dto.CompanyResponse
import reactor.core.publisher.Flux

interface GetAllCompaniesGateway {
    fun getAll(): Flux<CompanyResponse>
}