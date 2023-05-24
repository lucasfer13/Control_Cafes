package com.example.cafes.viewModel

import android.app.Application
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.AndroidViewModel
import com.example.cafes.models.User
import com.example.cafes.repositorios.UserRepository

class UserViewModel : AndroidViewModel {
    private val repository: UserRepository = UserRepository()

    constructor(application: Application) : super(application)

    fun addUser(user : User) {

    }



    fun getUsers() : SnapshotStateList<User> {
        repository.getUsers()
        return repository.allUsers
    }


}