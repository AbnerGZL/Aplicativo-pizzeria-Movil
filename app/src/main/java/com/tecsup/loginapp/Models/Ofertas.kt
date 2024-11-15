package com.tecsup.loginapp.Models

class Ofertas {
    var nombre: String? = null
    var direccion: String? = null

    fun Tienda(nombre: String?, direccion: String?) {
        this.nombre = nombre
        this.direccion = direccion
    }
    class Ofertas(var nombre: String?, var direccion: String?) {
        constructor() : this(null, null)
}
    }