package com.kongbarber.kongbackendapi.user.infrastructure.repository

import com.kongbarber.kongbackendapi.company.infrastructure.repository.Company
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(value = "users")
data class User(
    var _id: String? = null,
    var name: String? = null,
    var username: String? = null,
    var email: String? = null,
    var phone_number: String? = null,
    var password: String? = null,
    var disabled: Boolean = false,
    @DBRef var company: Company? = null,
    var device: String? = null,
    var ratedUs: Boolean = false,
    var configuration: Configuration = Configuration(),
    var type: UserType = UserType.hairdresser
)

data class Configuration(
    var table: String = "mobile"
)

enum class UserType {
    administrator,
    sys_admin,
    hairdresser
}