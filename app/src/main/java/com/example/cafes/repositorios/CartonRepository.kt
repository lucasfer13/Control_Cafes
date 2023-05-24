package com.example.cafes.repositorios

import com.example.cafes.api.APIAdapter
import com.example.cafes.models.Carton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartonRepository {
    var cartons: ArrayList<Carton> = ArrayList()

    constructor()

    fun getCartons() {
        APIAdapter.getApiService()?.cartons()?.enqueue(object : Callback<List<Carton>> {
            override fun onResponse(call: Call<List<Carton>>, response: Response<List<Carton>>) {
                cartons = response.body()?.toList() as ArrayList<Carton>
            }

            override fun onFailure(call: Call<List<Carton>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}