package com.example.basic.practica

fun main() {
    println("Ejercicio 1")
    println("de que color es el semaforo rojo/amarillo/verde: ")
    val color = readLine()?.lowercase() ?: ""
    print("Presionó el botón? (si o no): ")
    val boton = readLine()?.lowercase() ?: ""
    val mensaje = when {
        color == "verde" && boton == "si" -> "Esperar a rojo"
        color == "rojo" -> "Cruzar"
        color == "amarillo" -> "Prepárarme"
        else -> "Espera"
    }
    println("voy a $mensaje\n")
    println("=================")
    println("Ejercicio 2")
    println("Entrada al cine")
    print("cual es su edad: ")
    val edad = readLine()?.toIntOrNull() ?: 0
    val precio = when {
        edad < 12 -> 3
        edad >= 65 -> 4
        else -> 5
    }
    println("El precio de su entrada será $$precio\n")

    println("===========")
    println("Ejercicio 3")
    print("Coloque un numero ")
    val n1 = readLine()?.toIntOrNull() ?: 0
    var pares = 0
    for (i in 1..n1) {
        if (i % 2 == 0) pares++
    }
    println("Existen: $pares\n entre 1 y $n1")

    println("===========")
    println("Ejercicio 4")
    print("Coloque un numero ")
    val n2 = readLine()?.toIntOrNull() ?: 0
    var suma = 0
    for (i in 1..n2) {
        if (i % 3 == 0) suma += i
    }
    println("los múltiplos de 3 desde 1 $suma\n")

    println("===========")
    println("Ejercicio 5")
    print("Coloque los °C de temperatura ")
    val temp = readLine()?.toIntOrNull() ?: 0
    val estado = when {
        temp <= 0 -> "Sólido"
        temp in 1..99 -> "Líquido"
        else -> "Gas"
    }
    println("Estado: $estado\n")

    println("===========")
    println("Ejercicio 6")
    var continuar = true
    while (continuar) {
        println("1) Sumar  2) Restar  3) Salir")
        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("Número 1: ")
                val a = readLine()?.toDoubleOrNull() ?: 0.0
                print("Número 2: ")
                val b = readLine()?.toDoubleOrNull() ?: 0.0
                println("Resultado: ${a + b}")
            }
            2 -> {
                print("Número 1: ")
                val a = readLine()?.toDoubleOrNull() ?: 0.0
                print("Número 2: ")
                val b = readLine()?.toDoubleOrNull() ?: 0.0
                println("Resultado: ${a - b}")
            }
            3 -> continuar = false
        }
    }
    println()

    println("===========")
    println("Ejercicio 7")

    print("Coloque la contraseña: ")
    val pass = readLine() ?: ""
    val valida = pass.length >= 8 && pass.any { it.isDigit() }
    println(if (valida) "Contraseña valida" else "Falta seguridad\n")

    println("===========")
    println("Ejercicio 8")
    print("Texto: ")
    val texto = readLine()?.lowercase() ?: ""
    var vocales = 0
    for (c in texto) {
        if (c in "aeiou") vocales++
    }
    println("Vocales: $vocales\n")

    println("===========")
    println("Ejercicio 9")
    print("Número: ")
    val num = readLine()?.toIntOrNull() ?: 0
    for (i in 1..10) {
        println("$num x $i = ${num * i}")
    }
    println()

    println("===========")
    println("Ejercicio 10")
    print("Número: ")
    print("Nota 1: ")
    val n1nota = readLine()?.toDoubleOrNull() ?: 0.0
    print("Nota 2: ")
    val n2nota = readLine()?.toDoubleOrNull() ?: 0.0
    print("Nota 3: ")
    val n3nota = readLine()?.toDoubleOrNull() ?: 0.0
    val promedio = (n1nota + n2nota + n3nota) / 3
    println("Promedio: %.2f".format(promedio))
    println(if (promedio >= 14) "Aprobado" else "Reprobado")
}