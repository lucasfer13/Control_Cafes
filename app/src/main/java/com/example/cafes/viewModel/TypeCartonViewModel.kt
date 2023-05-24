package com.example.cafes.viewModel

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.cafes.models.TypeCarton
import com.example.cafes.repositorios.TypeCartonRepository

/**
 * Clase que contiene todos los datos necesarios para la vista
 * @author Lucas
 * */
class TypeCartonViewModel : ViewModel() {
    val repository : TypeCartonRepository = TypeCartonRepository()

    /**
     * Funcion para recoger una lista con todos los tipos de carton
     * @return Lista con los tipos de carton
     * */
    fun getTypeCartons() : SnapshotStateList<TypeCarton> {
        repository.getTypeCartons()
        return repository.typeCartons
    }
}