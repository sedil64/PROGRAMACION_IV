package com.example.basics

fun main(){
    println("VARIABLES")
    val estadio = "Monumental"
    var equipo = "Barcelona"

    equipo = "Emelec"

    println("Tipos de variables")
    println("Tipos de numéricos")
    println("Tipo Entero")
    val goles: Int = 3
    println(goles)

    println("Tipo Double")
    val promedio: Double = 2.5
    println(promedio)

    println("Tipo Float")
    val distanciaKm: Float = 10.5f
    println(distanciaKm)

    println("Tipo  Long")
    val espectadores: Long = 50000_000L
    println(espectadores)

    println("Tipo  Texto")
    val jugador: String = "Lionel Messi"
    println(jugador)

    println("Tipo  Char")

    println("Tipo  Lógico")
    val esLocal: Boolean = true
    println(esLocal)

    println("Nulidad")
    val entrenador: String? = null
    println(entrenador)

    println("Nulidad")
    val liga: String? = ""
    println(liga?.length)

    println("Operación de aserción no null")
    val longitudSegura = entrenador!!.length

    println("Interpolación de strings")
    val nombreEquipo: String = "Real Madrid"
    val titulos: Int = 15
    val pais: String = "España"

    println("${nombreEquipo.uppercase()} juega en ${pais}")
    println("En 5 años tendra : ${titulos+5} titulos")

    println("String Multilinea")
    val mensaje: String = """
        Equipo $nombreEquipo
        juega en el estadio $estadio
        el partido ha sido un éxito
        Gracias por su asistencia
                
    """
    println(mensaje)

    println("Conversiones")
    val textoGoles = "5"
    val golesConvertidos: Int = textoGoles.toInt()
    println(golesConvertidos)

    val puntos: Double = 75.8
    val puntosConvertidos: String = puntos.toString()
    println(puntosConvertidos)

}