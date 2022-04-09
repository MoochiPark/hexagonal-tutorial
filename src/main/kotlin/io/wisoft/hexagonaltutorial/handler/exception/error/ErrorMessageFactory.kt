package io.wisoft.hexagonaltutorial.handler.exception.error

import org.springframework.http.HttpStatus

object ErrorMessageFactory {

    fun from(httpStatus: HttpStatus, message: String): ErrorMessage {
        return ErrorMessage(
            status = httpStatus.value(),
            error = httpStatus.name,
            message = message
        )
    }

}