package io.wisoft.hexagonaltutorial.application.port.out

import io.wisoft.hexagonaltutorial.domain.Account

interface LoadAccountPort {

    @Throws(NoSuchElementException::class)
    fun loadAccount(accountId: String): Account

}