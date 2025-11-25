package com.example.basic.tarea

fun main() {
    println("Termostato doméstico de la tarea")
    print("Temperatura actual ")
    val temp = readln().toDouble()
    print("Preferencia (frío/templado/caliente): ")
    val pref = readln().lowercase()

    val resultado = when {
        pref == "frío" && temp > 22 -> "Encender aire"
        pref == "caliente" && temp < 18 -> "Encender calefacción"
        pref == "templado" && temp in 18.0..22.0 -> "En confort"
        else -> "Ventilar"
    }

    println(resultado)
}
