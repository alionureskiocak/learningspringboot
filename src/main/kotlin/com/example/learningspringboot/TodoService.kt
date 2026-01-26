package com.example.learningspringboot

import org.springframework.stereotype.Service

@Service
class TodoService {

    private val todos = mutableListOf<TodoResponse>()
    private var idCounter = 1L

    fun getAll() : List<TodoResponse>{
        return todos
    }

    fun add(request: TodoCreateRequest) : TodoResponse{
        val todo = TodoResponse(
            id = idCounter++,
            title = request.title,
            completed = false
        )
        todos.add(todo)
        return todo
    }
}