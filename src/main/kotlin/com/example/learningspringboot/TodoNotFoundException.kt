package com.example.learningspringboot

class TodoNotFoundException(id : Long) : RuntimeException("$id numaralı todo bulunamadı!")
