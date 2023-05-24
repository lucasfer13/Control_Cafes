package com.example.cafes.repositorios

import androidx.lifecycle.MutableLiveData
import com.example.cafes.api.APIAdapter
import com.example.cafes.models.Carton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartonRepository {
    var cartons: MutableLiveData<ArrayList<Carton>> = MutableLiveData()

    constructor()

    fun getCartons() {
        APIAdapter.getApiService()?.cartons()?.enqueue(object : Callback<List<Carton>> {
            override fun onResponse(call: Call<List<Carton>>, response: Response<List<Carton>>) {
                cartons.postValue(ArrayList(response.body()?.toList()))
            }

            override fun onFailure(call: Call<List<Carton>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}