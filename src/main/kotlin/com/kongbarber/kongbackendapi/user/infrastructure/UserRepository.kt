package com.kongbarber.kongbackendapi.user.infrastructure

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : ReactiveMongoRepository<User, String> {

}

@Document(value = "users")
data class User(
    var _id: String? = null,
    var name: String? = null,
    var username: String? = null,
    var email: String? = null,
    var phone_number: String? = null,
    var type: String = "hairdresser",
    var password: String? = null,
    var disabled: Boolean = false,
    var company: String? = null,
    var device: String? = null,
    var rateUs: Boolean = false,
    var configuration: Configuration? = null
)

data class Configuration(
    var table: String = "mobile"
)