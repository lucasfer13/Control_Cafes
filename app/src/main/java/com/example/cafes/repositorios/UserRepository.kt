package com.example.cafes.repositorios

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.cafes.api.APIAdapter
import com.example.cafes.api.APIService
import com.example.cafes.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    private val allUsers: MutableLiveData<ArrayList<User>> = MutableLiveData()

    constructor()

    fun init() {
        val api: APIService? = APIAdapter.getApiService()
        var call : Call<List<User>> = api!!.users()!!
        call.enqueue(object: Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    allUsers.postValue(ArrayList(response.body()?.toList()))
                    Log.d("USERFOUNDBYME", "Encontrados")
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    Log.d("USER", t.message!!)
                }

        })
    }

}