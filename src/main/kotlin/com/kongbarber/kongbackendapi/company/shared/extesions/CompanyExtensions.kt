package com.kongbarber.kongbackendapi.company.shared.extesions

import com.kongbarber.kongbackendapi.company.infrastructure.repository.Company
import com.kongbarber.kongbackendapi.company.infrastructure.repository.Payment
import com.kongbarber.kongbackendapi.company.infrastructure.repository.Plan
import com.kongbarber.kongbackendapi.company.infrastructure.repository.Service
import com.kongbarber.kongbackendapi.company.shared.dto.CompanyRequest
import com.kongbarber.kongbackendapi.company.shared.dto.CompanyResponse

fun CompanyRequest.toCompany(): Company =
    Company(
        name = this.name,
        shortName = this.shortName,
    )

fun Company.toCompanyResponse(): CompanyResponse =
    CompanyResponse(
        _id = this._id,
        name = this.name,
        shortName = this.shortName,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
        plan = this.plan?.let { it.toPlanResponse() },
        downgradePlanFree = this.downgradePlanFree,
        services = this.services?.let { it.toServicesRerponse() },
        planOld = this.planOld?.let { it.toPlanResponse() }
    )

fun Plan.toPlanResponse(): CompanyResponse.Plan =
    CompanyResponse.Plan(
        name = this.name,
        payment = this.payment!!.toPaymentResponse(),
        amountUsers = this.amountUsers,
        amountUsersAdmin = this.amountUsersAdmin,
        amountUsersCommon = this.amountUsersCommon,
        dateEnd = this.dateEnd,
        dateStarted = this.dateStarted,
        maxCash = this.maxCash
    )

fun Payment.toPaymentResponse(): CompanyResponse.Payment =
    CompanyResponse.Payment(
        price = this.price
    )

fun Service.toServiceResponse(): CompanyResponse.Service =
    CompanyResponse.Service(
        type = this.type,
        price = this.price
    )

fun List<Service>.toServicesRerponse(): List<CompanyResponse.Service> =
    this.map {
        it.toServiceResponse()
    }