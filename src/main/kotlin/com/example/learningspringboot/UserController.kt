package com.example.learningspringboot

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService : UserService
) {

    @PostMapping
    fun createUser(
        @Valid @RequestBody request: UserCreateRequest
    ) : UserResponse{
        return userService.createUser(request)
    }

    @GetMapping
    fun getUsers() : List<UserResponse>{
        return userService.getAllUsers()
    }
}