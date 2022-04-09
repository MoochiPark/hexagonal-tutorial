package io.wisoft.hexagonaltutorial.application.port.out

import io.wisoft.hexagonaltutorial.domain.Account

interface SaveAccountPort {

    fun saveAccount(account: Account): Account

}