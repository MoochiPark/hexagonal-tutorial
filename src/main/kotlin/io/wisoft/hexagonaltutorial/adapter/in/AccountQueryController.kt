package io.wisoft.hexagonaltutorial.adapter.`in`

import io.wisoft.hexagonaltutorial.application.port.`in`.FindAccountUseCase
import io.wisoft.hexagonaltutorial.application.port.`in`.FindAccountsUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class AccountQueryController(
    val findAccountUseCase: FindAccountUseCase,
    val findAccountsUseCase: FindAccountsUseCase,
) {

    @GetMapping("/accounts/{account-id}")
    fun findAccount(@PathVariable("account-id") accountId: String): ResponseEntity<FindAccountUseCase.FindAccountResponseQuery> {
        return ResponseEntity.status(HttpStatus.OK)
            .body(findAccountUseCase.findAccount(accountId))
    }

    @GetMapping("/accounts")
    fun findAccounts(): ResponseEntity<List<FindAccountUseCase.FindAccountResponseQuery>> {
        return ResponseEntity.status(HttpStatus.OK)
            .body(findAccountsUseCase.findAccounts())
    }

}