package io.wisoft.hexagonaltutorial.application.port.`in`

interface FindAccountsUseCase {

    fun findAccounts(): List<FindAccountUseCase.FindAccountResponseQuery>

}