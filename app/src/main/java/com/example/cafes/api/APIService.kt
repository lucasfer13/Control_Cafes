package com.example.cafes.api

import com.example.cafes.models.Carton
import com.example.cafes.models.TypeCarton
import com.example.cafes.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

/**
 * Funciones para usar la API
 * */
interface APIService {

    // Funciones para la gestion de usuarios
    @GET("api/users")
    fun users() : Call<List<User>>

    @POST("api/user")
    fun addUser(@Body u : User) : Call<User>


    // Funciones para la gestion de cartones
    @GET("api/cartons")
    fun cartons() : Call<List<Carton>>

    @POST("api/carton")
    fun addCarton(@Body c : Carton) : Call<Carton>

    @PUT("api/carton/{id}")
    fun modifyCarton(@Path("id") id : Int, @Body c : Carton) : Call<Carton>

    // Funciones para la gestion de tipos de carton
    @GET("api/types")
    fun getTypesCarton() : Call<List<TypeCarton>>
}