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

/**
 * Clase que contiene la conexion con la API y la lista con los Usuarios
 * @author Lucas
 * */
class UserRepository() {
    val allUsers: SnapshotStateList<User> = mutableStateListOf()

    /**
     * Funcion para llenar la lista de los usuarios
     * */
    fun getUsers() {
        allUsers.clear()
        val api: APIService? = APIAdapter.getApiService()
        var call : Call<List<User>> = api!!.users()!!
        call.enqueue(object: Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    val c : Collection<User> = response.body()?.toList() as Collection<User>
                    allUsers.addAll(c)
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    Log.d("USER_REPOSITORY", t.message!!)
                }

        })
    }

    /**
     * Funcion que actualiza un usuario
     * @param user Usuario que se va a modificar
     * */
    fun updateUser(user : User) {
        APIAdapter.getApiService()?.updateUser(user.id, user)?.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("USER_REPOSITORY", t.message!!)
            }

        })
    }

    /**
     * Funcion para añadir un usuario
     * @param user Usuario que se va a añadir
     * */
    fun addUser(user : User) : User? {
        var userReal : User? = null
        APIAdapter.getApiService()?.addUser(user)?.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                userReal = response.body()!!
                allUsers.add(userReal!!)
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("USER_REPOSITORY", t.message!!)
            }

        })
        return userReal
    }

}