package com.example.basics

fun main(){
    println("¡Bucles")
    val jedis = listOf("Luke", "Leia", "Obi-wan", "Yoda", "Ansoka")
    for((index,jedi) in jedis.withIndex()) {
        println("${index+1}.$jedi")
    }

    //Rangos ascendentes
    for (i in 0..20 step 5){
        println("Energia: $i%")
    }

    //Rangos descendentes
    for (countdown in 10 downTo 1){
        println("Energia: $countdown")
    }

    //Control de flujo

    for (jedi in jedis){
        if(jedi == "Obi-wan") continue // saltar esta interacción
        if(jedi == "Yoda") break // saltar esta interacción
        println("Entrenando a $jedi")
    }
}