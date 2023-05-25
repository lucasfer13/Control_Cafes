package com.example.cafes.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class TypeCarton(
                    @SerializedName("id") val id : Int = 0,
                    @SerializedName("total_coffee") val total : Int = 0,
                    @SerializedName("price") val price : Double = 0.0) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(total)
        parcel.writeDouble(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TypeCarton> {
        override fun createFromParcel(parcel: Parcel): TypeCarton {
            return TypeCarton(parcel)
        }

        override fun newArray(size: Int): Array<TypeCarton?> {
            return arrayOfNulls(size)
        }
    }

}