package com.example.cafes.screens

import com.example.cafes.models.Carton
import com.example.cafes.models.User
import com.example.cafes.repositorios.CartonRepository
import com.example.cafes.repositorios.UserRepository

val userRepository: UserRepository = UserRepository()
val cartonRepository: CartonRepository = CartonRepository()

fun call(){
    userRepository.init()
}

fun getUsers(): ArrayList<User> {
    return userRepository.userlist
}

fun getCartons(): ArrayList<Carton> {
    return cartonRepository.cartons
}