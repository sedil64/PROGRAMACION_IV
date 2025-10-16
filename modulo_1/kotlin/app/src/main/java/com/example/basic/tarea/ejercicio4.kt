package com.example.basic.tarea

fun main() {
    println("Simulador de ahorro semanal")
    print("meta ")
    val meta = readln().toDouble()
    print("Ahorro inicial ")
    var ahorro = readln().toDouble()

    var semana = 1
    var deposito = 5.0

    while (ahorro < meta) {
        ahorro += deposito
        println("Semana $semana → Depósito: $deposito  Total ahorrado: $ahorro")
        deposito += 10
        semana++
    }

    println("meta alcanzada en $semana semanas con $ahorro ahorrado")
}
