package com.example.cafes.viewModel

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.cafes.models.User
import com.example.cafes.repositorios.UserRepository
/**
 * Clase que contiene todas las funcionalidades necesarias para la vista enfocado al usuario
 * */
class UserViewModel() : ViewModel() {
    private val repository: UserRepository = UserRepository()

    /**
     * Funcion para añadir un usuario
     * @param user - El usuario que se va añadir
     * */
    fun addUser(user : User) {
        repository.addUser(user)
    }

    /**
     * Funcion para recoger todos los usuarios
     * @return Lista con los todos los usuarios
     * */
    fun getUsers() : SnapshotStateList<User> {
        repository.getUsers()
        return repository.allUsers
    }

    /**
     * Funcion para modificar un usuario
     * @param user Usuario a modificar
     * */
    fun modificarUsuario(user: User) {
        repository.updateUser(user)
    }
}