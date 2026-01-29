package com.example.learningspringboot

import jakarta.validation.constraints.NotBlank

data class TodoUpdateRequest(
    @field:NotBlank(message = "Updated title can't be blank!")
    val title : String,
    val completed : Boolean
)