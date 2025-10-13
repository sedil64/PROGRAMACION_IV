package com.example.basics

fun main(){
    for(i in 0 .. 100 step 10){
        when(i){
            0 -> println("Apagado");
            10 -> println("Conecte el cargador")
            50 -> println("Mitad de bateria")
            100 -> println("Cargado")
        }
    }
}

