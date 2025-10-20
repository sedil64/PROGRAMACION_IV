package com.example.basic.tarea
fun main() {
    println("Generador de usuario")
    print("Ingresa tu nombre ")
    val nombre = readln().trim().lowercase()
    print("Ingresa tu apellid ")
    val apellido = readln().trim().lowercase()

    var username = ""
    var i = 0

    while (i < nombre.length || i < apellido.length) {
        if (i < nombre.length) username += nombre.substring(i, minOf(i + 2, nombre.length))
        if (i < apellido.length) username += apellido.substring(i, minOf(i + 2, apellido.length))
        i += 2
    }

    var contador = 1
    while (username.length < 6) {
        username += contador
        contador++
    }

    println("tu nombre de usuario es: $username")
}
