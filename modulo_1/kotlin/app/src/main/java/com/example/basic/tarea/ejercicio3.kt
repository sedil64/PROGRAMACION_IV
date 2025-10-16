package com.example.basic.tarea

fun main() {
    println("Control de acceso por horario")

    val hora = readln().toInt()
    print("Rol (admin/invitado/empleado): ")
    val rol = readln().lowercase()

    val mensaje = when (rol) {
        "admin" -> "Acceso permitido"
        "invitado" -> if (hora in 9..17) "Acceso permitido" else "Acceso denegado"
        "empleado" -> if (hora in 6..20) "Acceso permitido" else "Acceso denegado"
        else -> "Rol no válido"
    }

    println(mensaje)
}
