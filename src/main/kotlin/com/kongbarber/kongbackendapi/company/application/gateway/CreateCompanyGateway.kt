package com.kongbarber.kongbackendapi.company.application.gateway

import com.kongbarber.kongbackendapi.company.shared.dto.CompanyRequest
import com.kongbarber.kongbackendapi.company.shared.dto.CompanyResponse
import reactor.core.publisher.Mono

interface CreateCompanyGateway {
    fun save(companyRequest: CompanyRequest): Mono<CompanyResponse>
}
