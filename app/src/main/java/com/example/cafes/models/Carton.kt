package com.example.cafes.models

import com.google.gson.annotations.SerializedName

data class Carton(
                    @SerializedName("id") val id : Int,
                    @SerializedName("consumend") var consumed : Int,
                    @SerializedName("total") val total : Int,
                    @SerializedName("id_user") val user : User,
                    @SerializedName("id_type") val type : TypeCarton)