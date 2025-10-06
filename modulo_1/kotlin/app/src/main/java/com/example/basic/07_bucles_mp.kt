package com.example.basics

fun main(){
    println("Bucles")
    val equipos = listOf("Barcelona", "Real Madrid", "Bayern", "PSG", "Manchester")
    for((index,equipo) in equipos.withIndex()) {
        println("${index+1}.$equipo")
    }

    for (i in 0..100 step 10){
        println("Posesion: $i%")
    }

    for (tiempo in 90 downTo 1){
        println("Minuto: $tiempo")
    }

    for (equipo in equipos){
        if(equipo == "Bayern") continue
        if(equipo == "PSG") break
        println("Analizando a $equipo")
    }
}