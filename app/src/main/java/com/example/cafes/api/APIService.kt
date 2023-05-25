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
 * @author Lucas
 * */
interface APIService {

    // Funciones para la gestion de usuarios

    /**
     * Funcion para recoger todos los usuarios
     * @return Retorna una llamada con una lista de usuarios
     * */
    @GET("api/users")
    fun users() : Call<List<User>>

    /**
     * Funcion para añadir un usuario
     * @param user El usuario a añadir
     * @return La llamada con los datos reales del usuario que se ha añadido
     * */
    @POST("api/user")
    fun addUser(@Body user : User) : Call<User>

    /**
     * Funcion para modificar un usuario
     * @param id Id del usuario
     * @param user El usuario a modificar
     * @return Retorna la llamada con el usuario modificado
     * */
    @PUT("api/user/{id}")
    fun updateUser(@Path("id") id : Int, user : User) : Call<User>


    // Funciones para la gestion de cartones

    /**
     * Funcion para recoger todos los cartones.
     * @return Llamada con la lista de los cartones
     * */
    @GET("api/cartons")
    fun cartons() : Call<List<Carton>>

    /**
     * Funcion para añadir un carton
     * @param c Carton a añadir
     * @return Llamada con los datos reales del carton
     * */
    @POST("api/carton")
    fun addCarton(@Body carton : Carton) : Call<Carton>

    /**
     * Funcion para modificar un carton
     * @param id La id del carton
     * @param c El carton a modificar
     * @return Llamada con los datos del carton
     * */
    @PUT("api/carton/{id}")
    fun modifyCarton(@Path("id") id : Int, @Body carton : Carton) : Call<Carton>

    // Funciones para la gestion de tipos de carton

    /**
     * Funcion para recoger todos los tipos de carton
     * @return Llamada con una lista con los tipos de carton
     * */
    @GET("api/types")
    fun getTypesCarton() : Call<List<TypeCarton>>
}