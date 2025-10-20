package com.example.basics
fun saludar(){
    println("Hola desde una funcion de Kotlin")
}

fun sumar(a: Int, b: Int): Int{
    return a + b
}
fun restar(a: Int, b: Int): Int{
    return a - b
}
fun multiplicar(a: Int, b: Int): Int{
    return a * b
}
fun dividir(a: Int, b: Int): Int{
    return a / b
}

fun cuadrado(numero: Int) = numero * numero

fun retornoMultiple(a: Int, b: Int): Pair<Int,Int> {
    val suma = a+b
    val resta = a-b
    return Pair(suma,resta)
}




fun main(){
    saludar()
    val resultado = sumar(5,6)
    println(resultado)
    println(cuadrado(5))
    println(retornoMultiple(15,5))
    val cuadradoLambda = {x: Int-> x*x}
    val saludoLambda = {nombre: String-> ", $nombre"}
    println(cuadradoLambda(4))
    println(saludoLambda("Juan Luis Guerra"))



    println("Calculadora")
    println("Primer valor")
    var valor1: Int = readln()?.toIntOrNull()?:0
    println("Segundo valor")
    var valor2: Int = readln()?.toIntOrNull()?:0
    println("Operación")
    var operacion: String = readln()
    when(operacion){
        "+" -> println(sumar(valor1,valor2))
        "-" -> println(restar(valor1, valor2))
        "*" -> println(multiplicar(valor1,valor2))
        "/" -> println(dividir(valor1,valor2))
    }}