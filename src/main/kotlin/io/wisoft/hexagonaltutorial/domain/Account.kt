package io.wisoft.hexagonaltutorial.domain

import org.mindrot.jbcrypt.BCrypt

data class Account(
    val accountId: String,
    val name: String,
    val email: String,
    var password: String = "",
    val permission: AccountPermission,
) {
    fun encryptPassword(password: String) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt())
    }

    fun checkPassword(password: String): Boolean {
        return !BCrypt.checkpw(password, this.password)
    }
}