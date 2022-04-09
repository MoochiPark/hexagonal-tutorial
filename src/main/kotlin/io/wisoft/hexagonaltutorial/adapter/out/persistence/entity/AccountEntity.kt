package io.wisoft.hexagonaltutorial.adapter.out.persistence.entity

import io.wisoft.hexagonaltutorial.domain.Account
import io.wisoft.hexagonaltutorial.domain.AccountPermission
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "account")
data class AccountEntity(
    @Id
    val accountId: String,
    val name: String,
    val email: String,
    val password: String,
    @Enumerated(value = EnumType.STRING)
    val permission: AccountPermission,
) {
    companion object {
        fun from(account: Account): AccountEntity {
            return account.run {
                AccountEntity(
                    accountId = accountId,
                    name = name,
                    email = email,
                    password = password,
                    permission = permission
                )
            }
        }

    }

    fun toDomain(): Account = Account(
        accountId = accountId,
        name = name,
        email = email,
        password = password,
        permission = permission
    )

}