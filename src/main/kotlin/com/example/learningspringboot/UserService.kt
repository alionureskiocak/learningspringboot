package com.example.learningspringboot

import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
){
    fun createUser(request: UserCreateRequest) : UserResponse{
        val user = User(username = request.username)
        val savedUser = userRepository.save(user)
        return UserResponse(id = savedUser.id!!, username = savedUser.username)
    }

    fun getAllUsers() : List<UserResponse>{
        return userRepository.findAll().map {
            UserResponse(id = it.id!!, username = it.username)
        }
    }
}