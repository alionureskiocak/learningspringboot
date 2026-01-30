package com.example.learningspringboot

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : JpaRepository<Todo,Long> {

    fun findAllByCompleted(completed : Boolean) : List<Todo>

    fun findAllByTitleContainingAndUserId(title : String, userId : Long) : List<Todo>

    fun findAllByUserId(userId: Long) : List<Todo>
}