package com.example.learningspringboot

import org.springframework.stereotype.Service


@Service
class HelloService {

    fun sayHello() : String{
        return "Hello Spring Boot"
    }

    fun sayHelloTo(name : String) : String{
        return "Hello to $name"
    }
}