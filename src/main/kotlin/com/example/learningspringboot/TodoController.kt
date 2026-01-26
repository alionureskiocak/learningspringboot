package com.example.learningspringboot

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
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
    fun getTodos() : List<TodoResponse>{
        return todoService.getAll()
    }

    @PostMapping
    fun addTodo(
       @Valid @RequestBody request: TodoCreateRequest
    ) : TodoResponse{
        return todoService.add(request)
    }
}