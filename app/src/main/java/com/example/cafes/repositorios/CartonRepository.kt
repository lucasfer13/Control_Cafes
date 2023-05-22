package com.example.cafes.repositorios

import androidx.lifecycle.MutableLiveData
import com.example.cafes.models.Carton

class CartonRepository {
    private val allCarton: MutableLiveData<ArrayList<Carton>> = MutableLiveData()
    private val cartons: ArrayList<Carton> = ArrayList()

    constructor()

    fun callAPI() : MutableLiveData<ArrayList<Carton>> {
        
        return allCarton
    }
}