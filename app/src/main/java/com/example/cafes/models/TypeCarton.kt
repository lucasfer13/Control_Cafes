package com.example.cafes.models

import com.google.gson.annotations.SerializedName

data class TypeCarton(
                    @SerializedName("id") val id : Int,
                    @SerializedName("total_coffee") val total : Int,
                    @SerializedName("price") val price : Double)