package com.kongbarber.kongbackendapi.analytics.infrastructure.repository.paymenttype.impl

import com.kongbarber.kongbackendapi.analytics.infrastructure.repository.paymenttype.GetSumTotalByPaymentRepository
import com.kongbarber.kongbackendapi.analytics.infrastructure.repository.paymenttype.document.AggreagationByPaymentType
import com.kongbarber.kongbackendapi.order.infrastructure.repository.Order
import org.bson.types.ObjectId
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import java.time.LocalDate

@Repository
class GetSumTotalByPaymentRepositoryImpl(
    private val reactiveMongoTemplate: ReactiveMongoTemplate
) : GetSumTotalByPaymentRepository {

    override fun getSumTotalByPayment(companyId: String?, start: LocalDate?, end: LocalDate?):
            Flux<AggreagationByPaymentType> =
        reactiveMongoTemplate
            .aggregate(
                Aggregation.newAggregation(
                    Aggregation.match(
                        Criteria("company").`is`(ObjectId(companyId))
                    ),
                    Aggregation.match(
                        Criteria("date").gte(start.toString())
                    ),
                    Aggregation.match(
                        Criteria("date").lte(end.toString())
                    ),
                    Aggregation
                        .group("paymentType")
                        .sum("total").`as`("totalByPayment"),
                    Aggregation.sort(
                        Sort.Direction.DESC,  "_id"
                    )
                ),
                Order::class.java,
                AggreagationByPaymentType::class.java
            )

}