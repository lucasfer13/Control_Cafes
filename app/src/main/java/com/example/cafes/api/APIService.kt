package com.example.cafes.api

import com.example.cafes.models.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface APIService {
    @GET("api/users")
    fun users() : Call<List<User>>

    @FormUrlEncoded
    @POST("api/user")
    fun addUser(@Field("admin") admin : Boolean,
                @Field("login") login : String,
                @Field("password") password : String) : Call<User>


}