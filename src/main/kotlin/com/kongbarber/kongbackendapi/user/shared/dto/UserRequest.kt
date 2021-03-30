package com.kongbarber.kongbackendapi.user.shared.dto

data class UserRequest(
    var name: String? = null,
    var username: String? = null,
    var email: String? = null,
    var phone_number: String? = null,
)