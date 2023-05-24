package com.example.cafes.viewModel

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.cafes.models.Carton
import com.example.cafes.repositorios.CartonRepository

class CartonViewModel() : ViewModel() {
    private val repository: CartonRepository = CartonRepository()


    fun getCartons() : SnapshotStateList<Carton> {
        repository.getCartons()
        return repository.cartons
    }

    fun restarCafeCarton(carton : Carton) {
    }

    fun getCafesRestantes(carton : Carton) : Int {
        return carton.total - carton.consumed
    }
}