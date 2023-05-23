package com.example.cafes.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.cafes.repositorios.UserRepository

class UserViewModel : AndroidViewModel {
    private val repository: UserRepository = UserRepository()

    constructor(application: Application) : super(application)
}