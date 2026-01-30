package com.example.learningspringboot

import jakarta.persistence.*
import javax.annotation.processing.Generated

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null,
    @Column(unique = true)
    val username : String = "",
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL])
    val todos : List<Todo> = mutableListOf()
)
