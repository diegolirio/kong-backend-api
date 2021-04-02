package com.kongbarber.kongbackendapi.company.application

import com.kongbarber.kongbackendapi.company.shared.dto.CompanyRequest
import com.kongbarber.kongbackendapi.company.shared.dto.CompanyResponse
import reactor.core.publisher.Mono

interface CreateCompanyUseCase {
    fun execute(companyRequest: CompanyRequest): Mono<CompanyResponse>
}
