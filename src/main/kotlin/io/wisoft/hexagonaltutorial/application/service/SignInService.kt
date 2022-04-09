package io.wisoft.hexagonaltutorial.application.service

import io.wisoft.hexagonaltutorial.application.port.`in`.SignInUseCase
import io.wisoft.hexagonaltutorial.application.port.out.LoadAccountPort
import io.wisoft.hexagonaltutorial.handler.exception.AccountNotFoundException
import io.wisoft.hexagonaltutorial.handler.exception.PasswordInvalidException
import org.springframework.stereotype.Service

@Service
class SignInService(
    val loadAccountPort: LoadAccountPort,
) : SignInUseCase {

    override fun signIn(command: SignInUseCase.SignInRequestCommand) {
        try {
            val findAccount = loadAccountPort.loadAccount(command.accountId)
            if (findAccount.checkPassword(command.password)) {
                throw PasswordInvalidException("잘못된 패스워드입니다.")
            }
        } catch (e: NoSuchElementException) {
            throw AccountNotFoundException("${command.accountId}는 존재하지 않는 사용자입니다.")
        }
    }

}