package com.example.learningspringboot

import jakarta.validation.constraints.NotBlank

data class TodoCreateRequest(
    @field:NotBlank(message = "Title can't be blank!")
    val title : String
)