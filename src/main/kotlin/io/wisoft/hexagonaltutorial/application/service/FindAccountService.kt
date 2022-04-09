package io.wisoft.hexagonaltutorial.application.service

import io.wisoft.hexagonaltutorial.application.port.`in`.FindAccountUseCase
import io.wisoft.hexagonaltutorial.application.port.out.LoadAccountPort
import io.wisoft.hexagonaltutorial.handler.exception.AccountNotFoundException
import org.springframework.stereotype.Service

@Service
class FindAccountService(
    val loadAccountPort: LoadAccountPort,
) : FindAccountUseCase {

    override fun findAccount(accountId: String): FindAccountUseCase.FindAccountResponseQuery {
        try {
            val findAccount = loadAccountPort.loadAccount(accountId)
            return findAccount.run {
                FindAccountUseCase.FindAccountResponseQuery(
                    accountId = accountId,
                    name = name,
                    permission = permission,
                    email = email
                )
            }
        } catch (e: NoSuchElementException) {
            throw AccountNotFoundException("${accountId}는 존재하지 않는 사용자입니다.")
        }
    }

}