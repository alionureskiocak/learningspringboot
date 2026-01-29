package com.example.learningspringboot

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/todos")
class TodoController(
    private val todoService: TodoService
) {

    @GetMapping
    fun getTodos(
        @RequestParam(required = false) completed : Boolean?
    ) : List<TodoResponse>{
        return if (completed !=null){
            todoService.getTodosByStatus(completed)
        }
        else{
            todoService.getAll()
        }
    }

    @PostMapping
    fun addTodo(
       @Valid @RequestBody request: TodoCreateRequest
    ) : TodoResponse{
        return todoService.add(request)
    }

    @PutMapping("/{id}")
    fun updateTodo(
        @PathVariable id : Long,
        @Valid @RequestBody request: TodoUpdateRequest
    ) : TodoResponse{
        return todoService.update(id,request)
    }
    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable id : Long){
        todoService.delete(id)
    }
}