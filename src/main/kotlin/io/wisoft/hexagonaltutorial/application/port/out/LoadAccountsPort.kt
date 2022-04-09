package io.wisoft.hexagonaltutorial.application.port.out

import io.wisoft.hexagonaltutorial.domain.Account

interface LoadAccountsPort {

    fun loadAccounts(): List<Account>

}