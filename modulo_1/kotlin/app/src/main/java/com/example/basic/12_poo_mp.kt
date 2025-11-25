package com.example.basics

data class Jugador(
    val nombre: String,
    val edad: Int,
    val goles: Int,
    val equipo: String?=null,
){
    val categoria: String
        get() = when{
            goles >= 30 -> "Estrella"
            goles >= 20 -> "Titular"
            goles >= 10 -> "Suplente"
            else -> "Reserva"
        }

    fun puedeSerCapitan(): Boolean = goles >= 20

    fun esJoven(): Boolean = edad <= 23
}

fun main(){
    val ronaldo = Jugador("Cristiano Ronaldo",
        28,
        35,
        "Real Madrid")
    println(ronaldo)

    val(nombre, edad, goles) = ronaldo
    println("Nombre del jugador ${nombre}, edad ${edad}, goles: ${goles}")

    val benzema = ronaldo.copy(nombre = "Benzema", goles = 25)
    println(benzema)

    println("Categoría de Benzema ${benzema.categoria}")
    println("Benzema puede ser capitán ${benzema.puedeSerCapitan()}")
}