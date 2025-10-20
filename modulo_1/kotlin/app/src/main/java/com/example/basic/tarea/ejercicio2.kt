package com.example.basic.tarea

fun main() {
    println("Costo de envío express")
    print("Distancia ")
    val distancia = readln().toDouble()
    print("¿Llueve? sí/no: ")
    val llueve = readln().lowercase()

    val base = when {
        distancia <= 5 -> 2.5
        distancia in 6.0..15.0 -> 5.0
        else -> 8.0
    }

    val total = if (llueve == "sí") base + 1.5 else base

    println("Costo total $total")
}

