package io.wisoft.hexagonaltutorial.application.service

import io.wisoft.hexagonaltutorial.application.port.`in`.SignUpUseCase
import io.wisoft.hexagonaltutorial.application.port.out.CheckAccountExistsPort
import io.wisoft.hexagonaltutorial.application.port.out.SaveAccountPort
import io.wisoft.hexagonaltutorial.domain.Account
import io.wisoft.hexagonaltutorial.handler.exception.IdDuplicatedException
import org.springframework.stereotype.Service

@Service
class SignUpService(
    val checkAccountExistsPort: CheckAccountExistsPort,
    val saveAccountPort: SaveAccountPort,
) : SignUpUseCase {

    override fun signUp(command: SignUpUseCase.SignUpRequestCommand) {
        if (checkAccountExistsPort.accountExists(command.accountId)) {
            throw IdDuplicatedException("${command.accountId}는 이미 존재하는 사용자입니다.")
        }

        val account = command.run {
            Account(
                accountId = accountId,
                name = name,
                email = email,
                permission = permission
            )
        }

        account.encryptPassword(command.password)
        saveAccountPort.saveAccount(account)
    }

}