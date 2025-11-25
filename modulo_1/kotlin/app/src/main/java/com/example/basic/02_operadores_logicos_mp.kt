package com.example.basics

fun main(){
    println("Operadores Lógicos")
    println("Bienvenidos a Resultados Deportivos")
    val goles: Int = 3
    val esLocal: Boolean = true
    val posicion: Int = 2
    val clasificaDirecto = goles>= 2 && esLocal && posicion <= 3
    val necesitaRepechaje = !esLocal || posicion > 4
    println("Clasifica directo: ${clasificaDirecto}")
    println("Necesita repechaje: ${necesitaRepechaje}")

}