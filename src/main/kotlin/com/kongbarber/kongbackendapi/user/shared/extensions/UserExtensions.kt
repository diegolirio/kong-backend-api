package com.kongbarber.kongbackendapi.user.shared.extensions

import com.kongbarber.kongbackendapi.user.infrastructure.repository.User
import com.kongbarber.kongbackendapi.user.shared.dto.ConfigurationResponse
import com.kongbarber.kongbackendapi.user.shared.dto.UserRequest
import com.kongbarber.kongbackendapi.user.shared.dto.UserResponse
import com.kongbarber.kongbackendapi.user.shared.dto.UserTypeResponse

fun User.toUserResponse(): UserResponse =
    UserResponse(
        _id = this._id,
        name = this.name,
        email = this.email,
        phone_number = this.phone_number,
        username = this.username,
        configuration = ConfigurationResponse(table = this.configuration.table),
        disabled = this.disabled,
        type = UserTypeResponse.valueOf(this.type.name),
        ratedUs = this.ratedUs,
        password = this.password
    )

fun UserRequest.toUser(): User =
    User(
        name = this.name,
        username = this.username,
        email = this.email,
        phone_number = this.phone_number,
        password = this.password
    )