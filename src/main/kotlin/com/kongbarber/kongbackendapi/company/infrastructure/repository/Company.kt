package com.kongbarber.kongbackendapi.company.infrastructure.repository

import org.springframework.data.mongodb.core.mapping.Document

@Document(value = "companies")
class Company(
    var _id: String? = null,
    var name: String? = null
)
