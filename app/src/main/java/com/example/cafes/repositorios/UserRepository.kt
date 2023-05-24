package com.example.cafes.repositorios

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.cafes.api.APIAdapter
import com.example.cafes.api.APIService
import com.example.cafes.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository() {
    val allUsers: SnapshotStateList<User> = mutableStateListOf()


    fun getUsers() {
        val api: APIService? = APIAdapter.getApiService()
        var call : Call<List<User>> = api!!.users()!!
        call.enqueue(object: Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    val c : Collection<User> = response.body()?.toList() as Collection<User>
                    allUsers.addAll(c)
                    Log.d("USERFOUNDBYME", "Encontrados")
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    Log.d("USER", t.message!!)
                }

        })
    }

}