package com.example.cafes.models

class Carton {
    private var id : Int
    private var total : Int
    private var gastados : Int
    private var acabado : Boolean

    constructor(id: Int, total: Int, gastados: Int, acabado: Boolean) {
        this.id = id
        this.total = total
        this.gastados = gastados
        this.acabado = acabado
    }
}