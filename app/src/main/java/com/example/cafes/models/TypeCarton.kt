package com.example.cafes.models

class TypeCarton {
    private var id : Int
        get() {return id}
    private var price : Double
        get() { return price }
    private var total : Int
        get() { return total }

    constructor(id: Int, price: Double, total: Int) {
        this.id = id
        this.price = price
        this.total = total
    }
}