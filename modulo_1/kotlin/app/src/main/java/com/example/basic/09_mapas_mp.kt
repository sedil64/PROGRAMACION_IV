package com.example.basics

fun main(){
    println("Mapas Deportivos")
    println("Mapa inmutable")

    val golesJugadores = mapOf(
        "Messi" to 32,
        "Haaland" to 28,
        "Mbappé" to 30,
        "Lewandowski" to 25
    )

    println("Goles de los jugadores ${golesJugadores}")

    println("Mapa mutable")
    val partidosJugados = mutableMapOf<String, Int>()
    partidosJugados["Messi"] = 35
    partidosJugados["Haaland"] = 33
    partidosJugados.put("Mbappé", 38)

    println("Partidos jugados ${partidosJugados}")

    for((jugador, goles) in golesJugadores){
        println("$jugador anoto $goles goles")
    }

    val estadiosVisitados = setOf("Camp Nou", "Bernabeu", "Etihad")
    println("Estadios visitados: ${estadiosVisitados}")

    val estadiosCampeones = setOf("Wembley", "Bernabéu", "Allianz")
    println("Estadios de champions: ${estadiosCampeones}")

    println("Conjunciones")
    val interseccion = estadiosCampeones intersect estadiosVisitados
    val union = estadiosCampeones union estadiosVisitados
    val diferencia = estadiosCampeones - estadiosVisitados
    println("Estadios visitados y champions: ${interseccion}")
    println("Todos los estadios: ${union}")
    println("Estadios champions no visitados: ${diferencia}")

    println("Validar horario de partido")

    println("Ingresa la hora del partido")
    var horaPartido: Int = readln()?.toIntOrNull()?:0

    when{
        horaPartido>=20-> println("Partido nocturno")
        horaPartido>=15-> println("Partido vespertino")
        else -> println("Partido matutino")
    }
}