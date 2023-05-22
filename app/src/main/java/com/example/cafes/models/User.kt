package com.example.cafes.models

import retrofit2.http.Field

class User {

    private var id : Int = 0
        get() { return id }
    private var esAdmin: Boolean
        get() {return esAdmin}
    private var userName: String
        get() { return userName }
    private var pass: String
        get() { return pass }
    private var cartons : ArrayList<Carton> = ArrayList<Carton>()
        get() { return cartons }

    constructor(
        @Field("id") id: Int,
        @Field("admin") esAdmin: Boolean,
        @Field("login") userName: String,
        @Field("password") pass: String,
        @Field("cartons") cartons: ArrayList<Carton>
    ) {
        this.id = id
        this.esAdmin = esAdmin
        this.userName = userName
        this.pass = pass
        this.cartons = cartons
    }

    constructor(esAdmin: Boolean, userName: String, pass: String) {
        this.esAdmin = esAdmin
        this.userName = userName
        this.pass = pass
    }


}