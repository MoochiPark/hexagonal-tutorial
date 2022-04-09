package io.wisoft.hexagonaltutorial.adapter.`in`

import io.wisoft.hexagonaltutorial.application.port.`in`.SignInUseCase
import io.wisoft.hexagonaltutorial.application.port.`in`.SignUpUseCase
import javax.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountCommandController(
    val signUpUseCase: SignUpUseCase,
    val signInUseCase: SignInUseCase,
) {

    @PostMapping("/signUp")
    fun signUp(@RequestBody @Valid command: SignUpUseCase.SignUpRequestCommand): ResponseEntity<HttpStatus> {
        signUpUseCase.signUp(command)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @PostMapping("/signIn")
    fun signIn(@RequestBody @Valid command: SignInUseCase.SignInRequestCommand): ResponseEntity<HttpStatus> {
        signInUseCase.signIn(command)
        return ResponseEntity(HttpStatus.OK)
    }

}