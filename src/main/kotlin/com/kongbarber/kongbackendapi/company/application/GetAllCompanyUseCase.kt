package com.kongbarber.kongbackendapi.company.application

import com.kongbarber.kongbackendapi.company.shared.dto.CompanyResponse
import reactor.core.publisher.Flux

interface GetAllCompanyUseCase {
    fun execute(): Flux<CompanyResponse>
}
