package com.example.cafes.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cafes.models.Carton
import com.example.cafes.repositorios.CartonRepository

class CartonViewModel() : ViewModel() {
    private val repository: CartonRepository = CartonRepository()


    fun getCartons() : MutableLiveData<ArrayList<Carton>> {
        repository.getCartons()
        return repository.cartons
    }

    fun restarCafeCarton(carton : Carton) {
    }

    fun getCafesRestantes(carton : Carton) : Int {
        return carton.total - carton.consumed
    }
}