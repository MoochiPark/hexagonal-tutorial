package io.wisoft.hexagonaltutorial.application.port.out

interface CheckAccountExistsPort {

    fun accountExists(accountId: String): Boolean

}