package com.example.basics

fun main(){
    var color: String = ""
    var estado_calle: String = ""
    when{
        color == "Verde" && estado_calle == "vacia"-> print("Avanzar")
        color == "Verde" && estado_calle == "con trafico" -> print("Precaución")
        color == "Amarillo" && estado_calle == "vacia" -> print("Precaución")
        else -> println("Esperar")
    }

    var mes: String = ""
    when(mes){
        "Enero", "Mayo", "Septiembre" -> print("Tierra")
        "Abril", "Agosto", "Diciembre" -> print("Fuego")
        "Junio", "Febrero", "Octubre" -> print("Aire")
        "Julio", "Marzo", "Noviembre" -> print("Tierra")
    }

    println("Calculadora")
    println("Primer valor")
    var value1: Int = readln()?.toIntOrNull()?:0
    println("Segundo valor")
    var value2: Int = readln()?.toIntOrNull()?:0
    println("Suma: ${value1 + value2}")
    println("Resta: ${value1 - value2}")
    println("Multiplicacion: ${value1 * value2}")
    println("Division: ${value1 / value2}")



    println("Calculadora")
    println("Primer valor")
    var valor1: Int = readln()?.toIntOrNull()?:0
    println("Segundo valor")
    var valor2: Int = readln()?.toIntOrNull()?:0
    println("Operación")
    var operacion: String = readln()
    when(operacion){
        "+" -> println(valor1+valor2)
        "-" -> println(valor1-valor2)
        "*" -> println(valor1*valor2)
        "/" -> println(valor1/valor2)
    }}