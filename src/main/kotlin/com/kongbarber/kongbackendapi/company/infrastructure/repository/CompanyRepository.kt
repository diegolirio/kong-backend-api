package com.kongbarber.kongbackendapi.company.infrastructure.repository

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CompanyRepository : ReactiveMongoRepository<Company, String> {

}
