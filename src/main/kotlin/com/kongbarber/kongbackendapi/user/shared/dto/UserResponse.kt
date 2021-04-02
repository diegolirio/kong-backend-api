package com.kongbarber.kongbackendapi.user.shared.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import java.time.LocalDateTime

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
data class UserResponse(
    var _id: String? = null,
    var name: String? = null,
    var username: String? = null,
    var password: String? = null,
    var email: String? = null,
    var phone_number: String? = null,
    var configuration: ConfigurationResponse? = null,
    var disabled: Boolean? = null,
    var ratedUs: Boolean? = null,
    var type: UserTypeResponse? = null,
    var company: String? = null,
    var createdAt: LocalDateTime,
    var updatedAt: LocalDateTime
)

data class ConfigurationResponse(
    var table: String = "mobile"
)

enum class UserTypeResponse(val type: String) {
    administrator("administrator"),
    sys_admin("sys_admin"),
    hairdresser("hairdresser")
}