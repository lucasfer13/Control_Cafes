package com.example.cafes.repositorios

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.cafes.api.APIAdapter
import com.example.cafes.models.Carton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Clase que contiene la conexion de la API con los modelos
 * @author Lucas
 * */
class CartonRepository() {
    var cartons: SnapshotStateList<Carton> = mutableStateListOf()

    /**
     * Funcion que llena la lista con los cartones
     * */
    fun getCartons() {
        APIAdapter.getApiService()?.cartons()?.enqueue(object : Callback<List<Carton>> {
            override fun onResponse(call: Call<List<Carton>>, response: Response<List<Carton>>) {
                cartons.addAll(ArrayList(response.body()?.toList()))
            }

            override fun onFailure(call: Call<List<Carton>>, t: Throwable) {
                Log.d("CARTON_REPOSITORY", t.message!!)
            }

        })
    }

    /**
     * Funcion que añade un carton y lo añade a la lista
     * @return Retorna el carton con los datos reales
     * */
    fun addCarton(c : Carton) : Carton? {
        var carton : Carton? = null
        APIAdapter.getApiService()?.addCarton(c)?.enqueue(object : Callback<Carton> {
            override fun onResponse(call: Call<Carton>, response: Response<Carton>) {
                carton = response.body()
                if (carton != null) cartons.add(carton!!)
            }

            override fun onFailure(call: Call<Carton>, t: Throwable) {
                Log.d("CARTON_REPOSITORY", t.message!!)
            }

        })
        return carton
    }

    /**
     * Funcion para modificar un carton
     * @param c El carton a modificar
     * */
    fun modifyCarton(c : Carton) {
        APIAdapter.getApiService()?.modifyCarton(c.id, c)?.enqueue(object : Callback<Carton> {
            override fun onResponse(call: Call<Carton>, response: Response<Carton>) {
            }

            override fun onFailure(call: Call<Carton>, t: Throwable) {
                Log.d("CARTON_REPOSITORY", t.message!!)
            }

        })
    }
}