package com.example.basic.tarea
import kotlin.random.Random

fun main() {
    println("Rally de resistencia")
    print("Número de etapas ")
    val etapas = readln().toInt()
    var energia = 100

    for (i in 1..etapas) {
        val terreno = Random.nextInt(1, 4)
        val perdida = when (terreno) {
            1 -> 5
            2 -> 10
            3 -> 15
            else -> 0
        }
        energia -= perdida
        val tipo = when (terreno) {
            1 -> "Asfalto"
            2 -> "Tierra"
            3 -> "Barro"
            else -> "Desconocido"
        }

        println("Etapa $i → Terreno: $tipo y la  energía restante: $energia")

        if (energia <= 0) {
            println("Abandona en la etapa $i.")
            println("Sesión terminada.")
            return
        }
    }

    println("Rally completado con energía $energia.")
    println("Sesión terminada.")
}
