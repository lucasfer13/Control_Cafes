package com.example.cafes.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.cafes.models.Carton
import com.example.cafes.repositorios.CartonRepository

class CartonViewModel : AndroidViewModel {
    private val repository: CartonRepository = CartonRepository()

    constructor(application: Application) : super(application)

    fun restarCafeCarton(carton : Carton) {

    }

    fun getCafesRestantes(carton : Carton) : Int {
        return carton.total - carton.consumed
    }
}