package com.example.cafes.repositorios

import androidx.lifecycle.MutableLiveData
import com.example.cafes.api.APIAdapter
import com.example.cafes.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    private val allCarton: MutableLiveData<ArrayList<User>> = MutableLiveData()
    private val cartons: ArrayList<User> = ArrayList()

    constructor()

    public fun getUsers() {
        //.enqueue(object : Callback<List<User>>)

        APIAdapter.getApiService()?.users()?.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}

private fun <T> Call<T>?.enqueue(callback: Callback<List<User>>) {}





