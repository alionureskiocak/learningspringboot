package com.example.learningspringboot

import jakarta.validation.constraints.NotBlank

data class UserCreateRequest(
    @field:NotBlank(message = "Username can't be empty!")
    val username : String
)