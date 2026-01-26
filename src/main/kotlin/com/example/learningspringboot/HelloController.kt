package com.example.learningspringboot

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class HelloController(
    private val helloService: HelloService
){

    @GetMapping("/hello")
    fun hello() : String{
        return helloService.sayHello()
    }

    @GetMapping("/hello/{name}")
    fun helloTo(@PathVariable name : String) : String{
        return helloService.sayHelloTo(name)
    }
}