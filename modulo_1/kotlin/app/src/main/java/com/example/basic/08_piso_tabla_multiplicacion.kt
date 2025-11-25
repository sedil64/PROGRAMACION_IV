package com.example.basics

fun main(){
    println("Tablas de multiplicar")
    println("Ingrese un numero")
    var numero: Int = readln()?.toIntOrNull()?:0

    for (i in 1..12){
        println("$numero x $i = ${numero * i}")
    }

    println("\nTablas de multiplicar")
    println("Ingrese un numero")
    var value1: Int = readln()?.toIntOrNull()?:0

    for (i in 1..12){
        println("$value1 x $i = ${value1 * i}")
    }
}