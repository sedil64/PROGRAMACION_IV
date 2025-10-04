package com.example.basics

fun main(){
    println("Tablas de multiplicar")

    var value1: Int = readln()?.toIntOrNull()?:0


    //Rangos ascendentes
    for (value1 in 0..12 step 1){
        println("tabla de multiplicar: $value1")
    }
}