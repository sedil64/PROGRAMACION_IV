package com.example.basic.tarea

fun main() {
    println("ATM Simplificado")
    var saldo = 0.0

    while (true) {
        println("\n1) Depositar\n2) Retirar\n3) Salir")
        print("Opción ")
        val opcion = readln().toInt()

        when (opcion) {
            1 -> {
                print("Monto a depositar: ")
                val monto = readln().toDouble()
                saldo += monto
                println("Saldo actual: $saldo")
            }
            2 -> {
                print("Monto a retirar: ")
                val monto = readln().toDouble()
                if (monto > saldo) {
                    println("Saldo insuficiente. Operación cancelada.")
                } else {
                    saldo -= monto
                    println("Saldo actual: $saldo")
                }
            }
            3 -> {
                println("Sesión terminada.")
                return
            }
            else -> println("Opción no válida.")
        }
    }
}
