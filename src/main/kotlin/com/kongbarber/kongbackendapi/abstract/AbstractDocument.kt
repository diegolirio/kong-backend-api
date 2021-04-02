package com.kongbarber.kongbackendapi.abstract

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

abstract class AbstractDocument(
    @Id var _id: String? = null,
    @CreatedDate var createAt: LocalDateTime? = null,
    @LastModifiedDate var updateAt: LocalDateTime? = null,
)