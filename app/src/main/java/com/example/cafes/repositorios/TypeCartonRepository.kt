package com.example.cafes.repositorios

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.cafes.api.APIAdapter
import com.example.cafes.models.TypeCarton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Clase que hace la conexion con la API y contiene los datos de los tipos de carton
 * @author Lucas
 * */
class TypeCartonRepository() {
    var typeCartons : SnapshotStateList<TypeCarton> = mutableStateListOf()

    /**
     * Funcion que recoge todos los tipos de carton
     * */
    fun getTypeCartons() {
        APIAdapter.getApiService()?.getTypesCarton()?.enqueue(object : Callback<List<TypeCarton>> {
            override fun onResponse(
                call: Call<List<TypeCarton>>,
                response: Response<List<TypeCarton>>
            ) {
                response.body()?.let { typeCartons.addAll(it.toList()) }
            }

            override fun onFailure(call: Call<List<TypeCarton>>, t: Throwable) {
                Log.d("TYPE_CARTON", t.message!!)
            }

        })
    }
}