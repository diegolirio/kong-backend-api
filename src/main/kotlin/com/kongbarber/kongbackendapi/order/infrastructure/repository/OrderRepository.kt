package com.kongbarber.kongbackendapi.order.infrastructure.repository

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository: ReactiveMongoRepository<Order, String> {

}
