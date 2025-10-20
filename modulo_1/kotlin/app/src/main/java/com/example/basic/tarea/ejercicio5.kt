package com.example.basic.tarea

fun main() {
    println("Detector de vocales consecutivas")
    print("Ingresa un texto ")
    val texto = readln()
    val vocales = "aeiouAEIOU"
    var contador = 0

    for (i in 0 until texto.length - 1) {
        val actual = texto[i]
        val siguiente = texto[i + 1]
        if (actual in vocales && siguiente in vocales) {
            contador++
        }
    }

    println("numero de vocales consecutivas: $contador")
}
