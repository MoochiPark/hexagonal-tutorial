package io.wisoft.hexagonaltutorial.application.port.`in`

import javax.validation.constraints.NotBlank

interface SignInUseCase {

    fun signIn(command: SignInRequestCommand)

    data class SignInRequestCommand(
        @field:NotBlank
        val accountId: String,

        @field:NotBlank
        val password: String,
    )

}