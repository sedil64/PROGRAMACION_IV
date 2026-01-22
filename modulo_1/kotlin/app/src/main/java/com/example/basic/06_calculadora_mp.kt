package com.example.basics

fun main(){
    var resultado: String = ""
    var clima: String = ""
    when{
        resultado == "Victoria" && clima == "soleado"-> print("Partido perfecto")
        resultado == "Victoria" && clima == "lluvioso" -> print("Victoria con dificultad")
        resultado == "Empate" && clima == "soleado" -> print("Oportunidad perdida")
        else -> println("Analizar estrategia")
    }

    var mes: String = ""
    when(mes){
        "Enero", "Mayo", "Septiembre" -> print("Temporada de Futbol")
        "Abril", "Agosto", "Diciembre" -> print("Temporada de Basquet")
        "Junio", "Febrero", "Octubre" -> print("Temporada de Tenis")
        "Julio", "Marzo", "Noviembre" -> print("Temporada de Voley")
    }

    println("Calculadora de Goles")
    println("Goles Equipo Local")
    var golesLocal: Int = readln()?.toIntOrNull()?:0
    println("Goles Equipo Visitante")
    var golesVisitante: Int = readln()?.toIntOrNull()?:0
    println("Total goles: ${golesLocal + golesVisitante}")
    println("Diferencia: ${golesLocal - golesVisitante}")
    println("Producto: ${golesLocal * golesVisitante}")
    println("Division: ${golesLocal / golesVisitante}")



    println("Calculadora de Puntos")
    println("Victorias")
    var victorias: Int = readln()?.toIntOrNull()?:0
    println("Empates")
    var empates: Int = readln()?.toIntOrNull()?:0
    println("Operación")
    var operacion: String = readln()
    when(operacion){
        "+" -> println(victorias+empates)
        "-" -> println(victorias-empates)
        "*" -> println(victorias*empates)
        "/" -> println(victorias/empates)
    }
}