package com.example.cafes.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.cafes.repositorios.TypeCartonRepository

class TypeCartonViewModel : AndroidViewModel {
    val repository : TypeCartonRepository = TypeCartonRepository()

    constructor(application: Application) : super(application)
}