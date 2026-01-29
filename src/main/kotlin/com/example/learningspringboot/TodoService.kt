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

    fun update(id : Long, request: TodoUpdateRequest) : TodoResponse{
        val index = todos.indexOfFirst { it.id == id }
        if (index == -1){
            throw TodoNotFoundException(id)
        }
        val updated = TodoResponse(
            id = id,
            title = request.title,
            completed = request.completed
        )
        todos[index] = updated
        return updated
    }

    fun delete(id : Long){
        val removed = todos.removeIf{ it.id == id }
        if (!removed){
            throw TodoNotFoundException(id)
        }
    }
}