package com.example.cafes.models

import com.google.gson.annotations.SerializedName

data class User(@SerializedName("id") val id : Int,
                @SerializedName("admin") val esAdmin : Boolean,
                @SerializedName("login") val userName : String,
                @SerializedName("password") val password : String)