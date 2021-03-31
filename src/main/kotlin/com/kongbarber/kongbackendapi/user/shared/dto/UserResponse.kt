package com.kongbarber.kongbackendapi.user.shared.dto

import com.kongbarber.kongbackendapi.user.infrastructure.repository.UserType

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
    var type: UserTypeResponse? = null
)

data class ConfigurationResponse(
    var table: String = "mobile"
)

enum class UserTypeResponse(val type: String) {
    administrator("administrator"),
    sys_admin("sys_admin"),
    hairdresser("hairdresser")
}