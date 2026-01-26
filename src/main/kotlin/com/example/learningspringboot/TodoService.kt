package com.example.learningspringboot

import org.springframework.stereotype.Service

@Service
class TodoService {

    private val todos = mutableListOf<Todo>()
    private var idCounter = 1L

    fun getAll() : List<Todo>{
        return todos
    }

    fun add(title : String) : Todo{
        val todo = Todo(
            id = idCounter++,
            title = title,
            completed = false
        )
        todos.add(todo)
        return todo
    }
}