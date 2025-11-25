package com.example.basics

fun main(){
    println("Mapas")
    println("Mapa inmutable")

    val fuerzaJedis = mapOf(
        "Luke" to 85,
        "Leia" to 80,
        "Obi-wan" to 95,
        "Yoda" to 100
    )

    println("Fuerza de los jedis: ${fuerzaJedis}")

    println("Mapa mutable")
    val misionesCompletadas = mutableMapOf<String, Int>()
    misionesCompletadas ["Luke"] = 15
    misionesCompletadas ["Leia"] = 12
    misionesCompletadas.put("Han",20)

    println("Misiones completadas: ${misionesCompletadas}")


    for((jedi, fuerza) in fuerzaJedis){
        println("$jedi tiene nivel de fuerza $fuerza")
    }

    val planetasVisitados = setOf("Tatooine", "Coruscant", "Dagobah")
    println("Planetas visitados: ${planetasVisitados}")

    val planetasPeligrosos = setOf("Mustafar", "Coruscant", "Korriban")
    println("Planetas visitados: ${planetasPeligrosos}")

    println("Conjunciones")
    val interseccion = planetasPeligrosos intersect planetasVisitados
    val union = planetasPeligrosos union planetasVisitados
    val diferencia = planetasPeligrosos - planetasVisitados
    println("planetas visitados y peligros: ${interseccion}")
    println("Todos los planetas: ${union}")
    println("Planetas seguros visitados: ${diferencia}")


    println("Vlidad de horario de clases")

    println("Ingresa tu hora de ingreso de 0")
    var ingreso: Int = readln()?.toIntOrNull()?:0


    when{
        ingreso>=7-> println("Horario de la mañana")
        ingreso>=14-> println("Horario de la tarde")
        else -> println("no tiene horario")
    }

}