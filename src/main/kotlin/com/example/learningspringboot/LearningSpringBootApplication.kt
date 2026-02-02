package com.example.learningspringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class LearningSpringBootApplication

fun main(args: Array<String>) {
	runApplication<LearningSpringBootApplication>(*args)
}
