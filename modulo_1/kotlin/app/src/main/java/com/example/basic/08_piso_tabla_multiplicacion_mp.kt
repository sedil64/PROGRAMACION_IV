package com.example.basics

fun main(){
    println("Tabla de Posiciones")
    println("Ingrese numero de equipo")
    var numeroEquipo: Int = readln()?.toIntOrNull()?:0

    for (jornada in 1..10 step 1){
        println("Equipo $numeroEquipo - Jornada $jornada: ${numeroEquipo * jornada} puntos")
    }

    println("\nTabla de Goles por Jornada")
    println("Ingrese goles por jornada")
    var golesPorJornada: Int = readln()?.toIntOrNull()?:0

    for (jornada in 1..12){
        println("Jornada $jornada: ${golesPorJornada * jornada} goles totales")
    }
}