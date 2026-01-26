package com.example.learningspringboot

data class TodoResponse(
    val id : Long,
    val title : String,
    val completed : Boolean
)