package io.wisoft.hexagonaltutorial.adapter.out.persistence

import io.wisoft.hexagonaltutorial.adapter.out.persistence.entity.AccountEntity
import io.wisoft.hexagonaltutorial.application.port.out.CheckAccountExistsPort
import io.wisoft.hexagonaltutorial.application.port.out.LoadAccountPort
import io.wisoft.hexagonaltutorial.application.port.out.LoadAccountsPort
import io.wisoft.hexagonaltutorial.application.port.out.SaveAccountPort
import io.wisoft.hexagonaltutorial.domain.Account
import org.springframework.stereotype.Component

@Component
class AccountAdapter(val accountRepository: AccountRepository) :
    CheckAccountExistsPort,
    SaveAccountPort,
    LoadAccountPort,
    LoadAccountsPort {

    override fun accountExists(accountId: String): Boolean {
        return !accountRepository.findById(accountId).isEmpty
    }

    override fun saveAccount(account: Account): Account {
        return accountRepository.save(AccountEntity.from(account)).toDomain()
    }

    override fun loadAccount(accountId: String): Account {
        return accountRepository.findById(accountId).orElseThrow().toDomain()
    }

    override fun loadAccounts(): List<Account> {
        return accountRepository.findAll().map(AccountEntity::toDomain)
    }


}