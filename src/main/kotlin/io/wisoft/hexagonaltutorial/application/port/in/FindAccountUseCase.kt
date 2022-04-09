package io.wisoft.hexagonaltutorial.application.port.`in`

import io.wisoft.hexagonaltutorial.domain.AccountPermission

interface FindAccountUseCase {

    fun findAccount(accountId: String): FindAccountResponseQuery

    data class FindAccountResponseQuery(
        val accountId: String,
        val name: String,
        val permission: AccountPermission,
        val email: String,
    )

}