package com.example.basics

fun main(){
    try{
        val promedio = 30/0
    }catch(e: Exception){
        println(e)
        println("Error al calcular estadísticas")
    }
}