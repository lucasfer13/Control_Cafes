package com.example.cafes.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Clase que contiene los datos de un Carton
 * @author Lucas
 * */
data class Carton(@SerializedName("id") val id : Int = 0,
                  @SerializedName("consumed") var consumed : Int = 0,
                  @SerializedName("total") val total : Int = 0,
                  @SerializedName("id_user") val user : User = User(),
                  @SerializedName("id_type") val type : TypeCarton = TypeCarton()): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readParcelable(User::class.java.classLoader)!!,
        parcel.readParcelable(TypeCarton::class.java.classLoader)!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(consumed)
        parcel.writeInt(total)
        parcel.writeParcelable(user, flags)
        parcel.writeParcelable(type, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "Carton(id=$id, consumed=$consumed, total=$total, user=$user, type=$type)"
    }

    companion object CREATOR : Parcelable.Creator<Carton> {
        override fun createFromParcel(parcel: Parcel): Carton {
            return Carton(parcel)
        }

        override fun newArray(size: Int): Array<Carton?> {
            return arrayOfNulls(size)
        }
    }


}
