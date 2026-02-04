package com.example.learningspringboot

import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleValidationException(
        ex : MethodArgumentNotValidException
    ) : ErrorResponse{

        val errors = ex.bindingResult.fieldErrors.map {
            FieldErrorResponse(
                field = it.field,
                message = it.defaultMessage ?: "Geçersiz Değer"
            )
        }
        return ErrorResponse(errors)
    }

    @ExceptionHandler(TodoNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleTodoNotFound(
        ex : TodoNotFoundException
    ) : Map<String,String>{
        return mapOf(
            "error" to ex.message!!
        )
    }

    @ExceptionHandler(UserNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleUserNotFound(
        ex : UserNotFoundException
    ) : Map<String,String>{
        return mapOf(
            "error" to ex.message!!
        )
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleAllExceptions(ex: Exception): Map<String, String> {
        return mapOf("error" to (ex.message ?: "Beklenmedik bir hata oluştu!"))
    }
}