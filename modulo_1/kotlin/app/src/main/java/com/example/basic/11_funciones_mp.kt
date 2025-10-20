package com.example.basics

fun mostrarResultado(){
    println("Resultado del partido desde función")
}

fun sumarGoles(local: Int, visitante: Int): Int{
    return local + visitante
}

fun calcularDiferencia(local: Int, visitante: Int): Int{
    return local - visitante
}

fun calcularPuntos(victorias: Int, empates: Int): Int{
    return victorias * 3 + empates
}

fun promedioGoles(goles: Int, partidos: Int): Int{
    return goles / partidos
}

fun marcadorCuadrado(goles: Int) = goles * goles

fun resultadoCompleto(local: Int, visitante: Int): Pair<Int,String>{
    val total = local + visitante
    val resultado = if(local > visitante) "Victoria" else if(local < visitante) "Derrota" else "Empate"
    return Pair(total, resultado)
}

fun main(){
    mostrarResultado()
    val totalGoles = sumarGoles(3,2)
    println(totalGoles)
    println(marcadorCuadrado(4))
    println(resultadoCompleto(2,2))

    val golesLambda = {x: Int-> x*2}
    val equipoLambda = {nombre: String-> "Equipo: $nombre"}
    println(golesLambda(3))
    println(equipoLambda("Barcelona"))

    println("Calculadora de puntos")
    println("Goles local")
    var golesLocal: Int = readln()?.toIntOrNull()?:0
    println("Goles visitante")
    var golesVisitante: Int = readln()?.toIntOrNull()?:0
    println("Operación")
    var operacion: String = readln()

    when(operacion){
        "+" -> println(sumarGoles(golesLocal, golesVisitante))
        "-" -> println(calcularDiferencia(golesLocal, golesVisitante))
        "*" -> println(calcularPuntos(golesLocal, golesVisitante))
        "/" -> println(promedioGoles(golesLocal, golesVisitante))
    }
}