package com.example.basics

class RendimientoBajoException(message: String): Exception(message)
class PartidoPeligrosoException(message: String): Exception(message)

fun jugarPartido(condicionFisica: Int, rivalNivel: Int): String{
    return try{
        when{
            condicionFisica < 40 -> throw RendimientoBajoException("Condición física insuficiente: $condicionFisica")
            rivalNivel > 85 -> throw PartidoPeligrosoException("Rival de alto nivel")
            else -> "Partido completado exitosamente"
        }
    }catch(e: RendimientoBajoException){
        "Error: ${e.message}. Requiere entrenamiento"
    }catch(e: PartidoPeligrosoException){
        "Error: ${e.message}. Nivel rival $rivalNivel"
    }catch(e: Exception){
        "${e.message}"
    }finally{
        "Informe técnico enviado"
    }
}

fun main(){
    println(jugarPartido(30, 70))
    println(jugarPartido(80, 90))
}