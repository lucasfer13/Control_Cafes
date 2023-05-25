package com.example.cafes.viewModel

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.cafes.models.Carton
import com.example.cafes.repositorios.CartonRepository
import com.example.cafes.screens.cartonViewModel

/**
 * Classe que contiene las funciones necesarias para la vista
 * @author Lucas
 * */
class CartonViewModel() : ViewModel() {
    private val repository: CartonRepository = CartonRepository()

    /**
     * Funcion para recoger todos los cartones
     * @return Lista con todos los cartones
     * */
    fun getCartons() : SnapshotStateList<Carton> {
        repository.getCartons()
        return repository.cartons
    }

    /**
     * Funcion para restar un cafe al carton
     * */
    fun restarCafeCarton(carton : Carton, index : Int) {
        carton.consumed++
        carton.restantes--
        repository.modifyCarton(carton)
        if (carton.total <= carton.consumed) cartonViewModel.repository.cartons.remove(carton)
    }

    /**
     * Funcion para saber los cafes restantes de un carton
     * @return Los cafes restantes del carton
     * */
    fun getCafesRestantes(carton : Carton) : Int {
        carton.restantes = carton.total - carton.consumed
        return carton.restantes
    }

    /**
     * Funcion para añadir un carton
     * */
    fun addCarton(carton : Carton) {
        repository.addCarton(carton)
    }
}