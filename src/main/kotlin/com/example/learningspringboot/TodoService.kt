package com.example.learningspringboot

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TodoService(
    private val todoRepository : TodoRepository,
    private val userRepository: UserRepository
) {

    fun getTodos(completed: Boolean?, pageable: Pageable): Page<TodoResponse> {
        val todos = if (completed != null) {
            todoRepository.findAllByCompleted(completed, pageable)
        } else {
            todoRepository.findAll(pageable)
        }
        return todos.map { it.toResponse() }
    }

    fun getTodosByUserId(userId: Long) : List<TodoResponse> {
        return todoRepository.findAllByUserId(userId).map {
            it.toResponse()
        }
    }

    fun searchTodos(keyword : String, userId : Long) : List<TodoResponse>{

        val results = todoRepository.findAllByTitleContainingAndUserId(keyword,userId)
        return results.map {
            it.toResponse()
        }
    }


    fun getAll(pageable : Pageable) : Page<TodoResponse>{
        return todoRepository.findAll(pageable).map { it.toResponse() }
    }

    fun add(request: TodoCreateRequest) : TodoResponse{

        val user = userRepository.findById(request.userId)
            .orElseThrow{ UserNotFoundException(request.userId) }

        val todo = Todo(
            title = request.title,
            completed = false,
            user = user
        )
        val savedTodo = todoRepository.save(todo)
        return savedTodo.toResponse()
    }

    fun update(id : Long, request: TodoUpdateRequest) : TodoResponse{
       val todo = todoRepository.findById(id)
           .orElseThrow{ TodoNotFoundException(id) }

        todo.title = request.title
        todo.completed = request.completed
        return todoRepository.save(todo).toResponse()
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