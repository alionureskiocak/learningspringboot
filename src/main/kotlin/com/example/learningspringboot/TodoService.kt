package com.example.learningspringboot

import org.springframework.stereotype.Service

@Service
class TodoService(
    private val todoRepository : TodoRepository
) {



    fun getAll() : List<TodoResponse>{
        return todoRepository.findAll().map { it.toResponse() }
    }

    fun add(request: TodoCreateRequest) : TodoResponse{
        val todo = Todo(
            title = request.title,
            completed = false
        )
        val savedTodo = todoRepository.save(todo)
        return savedTodo.toResponse()
    }

    fun update(id : Long, request: TodoUpdateRequest) : TodoResponse{
       val existingTodo = todoRepository.findById(id)
           .orElseThrow{ TodoNotFoundException(id) }
        val updatedTodo = existingTodo.copy(
            title = request.title,
            completed = request.completed
        )
        return todoRepository.save(updatedTodo).toResponse()
    }

    fun delete(id : Long){
        if (!todoRepository.existsById(id)){
            throw TodoNotFoundException(id)
        }
        todoRepository.deleteById(id)
    }

    private fun Todo.toResponse() = TodoResponse(
        id = this.id!!,
        title = this.title,
        completed = this.completed
    )
}