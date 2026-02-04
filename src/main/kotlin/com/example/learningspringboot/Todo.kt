package com.example.learningspringboot

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)
class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null,
    var title : String = "",
    var completed : Boolean = false,
    @ManyToOne
    @JoinColumn(name = "user_id")
    val user : User? = null,

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdAt : LocalDateTime? = null,

    @LastModifiedDate
    @Column(nullable = false)
    var updatedAt : LocalDateTime? = null
)