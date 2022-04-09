package io.wisoft.hexagonaltutorial.handler.exception.error

import org.springframework.validation.BindingResult
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class ErrorMessage(
    val current: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    val status: Int,
    val error: String,
    var message: String = ""
) {
    fun setMessage(bindingResult: BindingResult) {
        this.message = bindingResult.fieldErrors.joinToString { "[${it.field}: ${it.defaultMessage.toString()}]" }
    }
}