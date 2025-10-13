package com.example.basics

enum class TipoTorneo(val nombre: String, val prestigio: Int){
    CHAMPIONS("Champions League", 100){
        override fun descripcion() = "Máxima competición europea"
    },
    LIGA("Liga Nacional", 85){
        override fun descripcion() = "Torneo doméstico principal"
    },
    COPA("Copa Nacional", 75){
        override fun descripcion() = "Torneo eliminatorio nacional"
    },
    MUNDIAL("Copa del Mundo", 100){
        override fun descripcion() = "Máximo torneo internacional"
    };

    abstract fun descripcion(): String

    companion object{
        fun porNombre(nombre: String) = values().find{it.nombre == nombre}
    }
}

class Campeonato(val tipo: TipoTorneo, val campeon: String){
    fun celebrar() = "¡${campeon} campeón de ${tipo.nombre}!"
    fun info() = "${tipo.descripcion()} - Prestigio ${tipo.prestigio}"
}

fun main(){
    val championsMadrid = Campeonato(TipoTorneo.CHAMPIONS, "Real Madrid")
    println(championsMadrid)
    println(championsMadrid.celebrar())
    println(championsMadrid.info())

    val mundialArgentina = Campeonato(TipoTorneo.MUNDIAL, "Argentina")
    println(mundialArgentina)
    println(mundialArgentina.celebrar())
    println(mundialArgentina.info())
}