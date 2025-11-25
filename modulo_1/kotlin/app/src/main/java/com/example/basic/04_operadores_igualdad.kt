package com.example.basics

fun main(){
    println("Operadores igualda")
    val nombre1: String = "Yoda"
    val nombre2: String = "Yoda"
    val nombre3: String = String("Yoda".toCharArray())

    println("Igualdad Estructural (Contenido)")
    println("nombre1===nombre2")
    println("nombre1===nombre3")
    println("Igualdad referencial (misma instancia)")
    println("nombre1===nombre2")
    println("nombre1===nombre3")


}