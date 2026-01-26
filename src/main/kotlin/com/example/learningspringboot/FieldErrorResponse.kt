package com.example.learningspringboot

import org.apache.logging.log4j.message.Message

data class FieldErrorResponse(
    val field : String,
    val message: String
)