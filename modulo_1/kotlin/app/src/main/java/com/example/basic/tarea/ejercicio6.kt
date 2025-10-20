package com.example.basic.tarea

fun main() {
    println("Cuenta regresiva")

    for (i in 30 downTo 0) {
        when (i) {
            20 -> println("20 → Chequeo de sistemas")
            10 -> println("10 → ultimos ajustes")
            0 -> println("0 → Despegue")
            else -> println(i)
        }
    }
}
