package com.example.basic.tarea

fun main() {
    println("Cola de supermercado")

    var totalDia = 0.0
    var clientes = 0

    while (true) {
        print("Nuevo cliente o 'fin' para terminar ")
        val entrada = readln().lowercase()
        if (entrada == "fin") break

        val total = entrada.toDouble()
        print("Número de ítems ")
        val items = readln().toInt()

        var totalCliente = total
        if (total > 100) {
            totalCliente *= 0.95
            println("Descuento aplicado")
        }

        if (items > 10) {
            println("la caja rápida no  esta disponible.")
        }

        println("Total cliente: $totalCliente\n")
        totalDia += totalCliente
        clientes++
    }

    println("Total del día: $totalDia  y los clientes atendidos son: $clientes")
}
