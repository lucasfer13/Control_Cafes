package com.example.cafes.screens

import com.example.cafes.models.User
import com.example.cafes.repositorios.UserRepository

val userRepository: UserRepository = UserRepository()

fun call(){
    userRepository.init()
}

fun getUsers(): ArrayList<User> {
    return userRepository.userlist
}