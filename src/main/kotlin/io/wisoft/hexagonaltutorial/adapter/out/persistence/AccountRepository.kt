package io.wisoft.hexagonaltutorial.adapter.out.persistence

import io.wisoft.hexagonaltutorial.adapter.out.persistence.entity.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<AccountEntity, String> {
}