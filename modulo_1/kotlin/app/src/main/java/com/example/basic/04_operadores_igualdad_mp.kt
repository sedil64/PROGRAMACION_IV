package com.example.basics

fun main(){
    println("Operadores igualdad")
    val equipo1: String = "Bayern"
    val equipo2: String = "Chelsea"
    val equipo3: String = String("Bayern".toCharArray())

    println("Igualdad Estructural (Contenido)")
    println("equipo1==equipo2: ${equipo1==equipo2}")
    println("equipo1==equipo3: ${equipo1==equipo3}")
    println("Igualdad referencial (misma instancia)")
    println("equipo1===equipo2: ${equipo1===equipo2}")
    println("equipo1===equipo3: ${equipo1===equipo3}")

}