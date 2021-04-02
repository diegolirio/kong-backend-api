package com.kongbarber.kongbackendapi.user.infrastructure.repository

import org.bson.types.ObjectId
import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(value = "users")
//@CompoundIndex(def = "{'username'}", name = "username_1")
data class User(
    @Id var _id: String? = null,
    @NotNull var name: String? = null,
    var username: String? = null,
    var email: String? = null,
    var phone_number: String? = null,
    var password: String? = null,
    var disabled: Boolean = false,
    var company: ObjectId? = null,
    var device: String? = null,
    var ratedUs: Boolean = false,
    var configuration: Configuration = Configuration(),
    var type: UserType = UserType.hairdresser,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null
)

data class Configuration(
    var table: String = "mobile"
)

enum class UserType {
    administrator,
    sys_admin,
    hairdresser
}