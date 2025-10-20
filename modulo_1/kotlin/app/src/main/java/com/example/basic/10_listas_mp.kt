package com.example.basics

fun main(){
    println("Listas de Resultados")

    val inmutable: List<Int> = listOf(3,1,2)
    println("Resultados inmutables ${inmutable}")

    val mutableResultados: MutableList<Int> = mutableListOf(0,2,1)
    println("Resultados mutables ${mutableResultados}")
    mutableResultados.add(4)
    println("Resultados mutables ${mutableResultados}")
    mutableResultados.removeAt(index = 0)
    println("Resultados mutables ${mutableResultados}")

    for(resultado in mutableResultados) println(resultado)

    println("Operaciones con resultados")

    val equipos = mutableListOf("Barcelona","Madrid")
    equipos.add("Bayern")
    equipos+="PSG"
    equipos.add(index = 1, "City")

    println(equipos)
    equipos.remove(element = "Madrid")
    println(equipos)
    equipos.removeAt(index = 0)
    println(equipos)
    equipos[0]="Liverpool"
    println(equipos)
    equipos.clear()
    println(equipos.isEmpty())

    println("Busqueda de equipos")
    val ligas = mutableListOf("Premier", "LaLiga", "Bundesliga")
    println(ligas.find {it.startsWith("L")})
    println(ligas.firstOrNull() {it.length>7})
    println(ligas.any {it.contains('P')})
    println(ligas.none {it =="SerieA"})

    println("Ordenamiento de posiciones")
    val posiciones = mutableListOf(5,1,3,2,8,4,6,9,7)
    println(posiciones.sorted())
    println(posiciones.sortedDescending())
    println(posiciones.distinct())
}