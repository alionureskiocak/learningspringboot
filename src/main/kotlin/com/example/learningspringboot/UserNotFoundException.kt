package com.example.learningspringboot

class UserNotFoundException(userId : Long) : RuntimeException("$userId couldn't find!") {
}