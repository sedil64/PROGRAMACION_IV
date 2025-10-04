package com.example.basics

fun main(){
    println("Estructuras de control")
    println("Condicionales")

    val value1 = 10
    val value2 = 15
    if (value1>value2){
        println("El mayor es ${value1}")
    } else {
        println("El mayor es ${value2}")
    }

    println("Rango segun el nivel de fuerza")
    var fuerza: Int = 10
    if (fuerza > 10){
        println("Maestro")
    } else if (fuerza > 5) {
        println("Caballero Jedi")
    } else {
        println("Padawan")
    }

    var tidoDroide: String = "R2-D2"
    when(tidoDroide){
        "R2-D2", "R2-Q5" -> println("Droide astromecánico")
        "C-3PO", "C-3PA" -> println("Droide de protocolo")
        "BB-8", "BB-9E" -> println("Droide de nueva generación")
        else -> println("Modelo Desconocido")
    }
    var peligro: Int = 5
    var recompensa: Int = 5
    when{
        peligro>8 && recompensa < 1000-> println("Misión rechazada")
        peligro<=3 -> println("Misión Aceptada")
        else -> println("Requiere Evaluación Adicional")
    }
}