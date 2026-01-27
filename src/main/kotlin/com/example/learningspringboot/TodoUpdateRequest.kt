package com.example.learningspringboot

data class TodoUpdateRequest(
    val title : String,
    val completed : Boolean
)