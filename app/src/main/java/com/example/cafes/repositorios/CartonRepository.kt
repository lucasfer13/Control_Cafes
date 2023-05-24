package com.example.cafes.repositorios

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.cafes.api.APIAdapter
import com.example.cafes.models.Carton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartonRepository {
    var cartons: SnapshotStateList<Carton> = mutableStateListOf()

    constructor()

    fun getCartons() {
        APIAdapter.getApiService()?.cartons()?.enqueue(object : Callback<List<Carton>> {
            override fun onResponse(call: Call<List<Carton>>, response: Response<List<Carton>>) {
                cartons.addAll(ArrayList(response.body()?.toList()))
            }

            override fun onFailure(call: Call<List<Carton>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}