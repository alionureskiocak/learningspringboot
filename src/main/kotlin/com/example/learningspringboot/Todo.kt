package com.example.learningspringboot

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null,
    val title : String = "",
    val completed : Boolean = false,
    @ManyToOne
    @JoinColumn(name = "user_id")
    val user : User? = null
)