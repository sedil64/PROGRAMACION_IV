package com.example.basics

fun main(){
    println("Estructuras de control")

    val golesLocal = 3
    val golesVisitante = 2
    if (golesLocal>golesVisitante){
        println("Gana el local por ${golesLocal} goles")
    } else {
        println("Gana el visitante con ${golesVisitante} goles")
    }

    println("Categoria")
    var puntos: Int = 45
    if (puntos > 60){
        println("Campeon")
    } else if (puntos > 40) {
        println("Clasificado")
    } else {
        println("Eliminado")
    }

    var deporte: String = "Futbol"
    when(deporte){
        "Futbol", "Futsal" -> println("Deporte de pelota")
        "Basquet", "Voley" -> println("Deporte con red")
        "Tenis", "Padel" -> println("Deporte de raqueta")
        else -> println("Deporte Desconocido")
    }
    var goles: Int = 5
    var tarjetas: Int = 2
    when{
        goles>3 && tarjetas < 2-> println("Partido limpio")
        goles<=1 -> println("Partido defensivo")
        else -> println("Requiere Revision del arbitro")
    }
}