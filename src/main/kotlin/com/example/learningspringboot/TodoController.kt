package com.example.learningspringboot

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/todos")
class TodoController(
    private val todoService: TodoService
) {

    @GetMapping
    fun getTodos() : List<Todo>{
        return todoService.getAll()
    }

    @PostMapping
    fun addTodo(
        @RequestParam title : String
    ) : Todo{
        return todoService.add(title)
    }
}