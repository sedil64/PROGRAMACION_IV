package com.example.basics

fun main(){
    println("Ejercicios")
    println("Ejercicios 1")
    var numero = readln().toInt()

    print("pusiste este numero $numero")

    var suma: Int = 0
    for (i in 0..numero) {

        suma += i
        print(suma)

    }

}