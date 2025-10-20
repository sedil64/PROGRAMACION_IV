package com.example.basics

enum class TipoSable (val color: String, val poder: Int){
    AZUL("azul", 85) {
        override fun descripcion() = "Sable tradicional de los Jedi"
    },
    VERDE("verde", 90) {
        override fun descripcion() = "Sable de los Jedi consulares"
    },
    ROJO("rojo", 95) {
        override fun descripcion() = "Sables de los Sith"
    },
    MORADO("morado", 95) {
        override fun descripcion() = "Sable Equilibrada de luz y oscuridad"
    };
    abstract fun descripcion(): String
    companion object{
        fun porColor(color: String)= values().find{it.color==color}
    }

}

class SableDeLuz(val tipo: TipoSable, val portador: String){
    fun activar() = "¡ZZZrum! El sable color ${tipo.color} de ${portador} se enciente"
    fun info()= "${tipo.descripcion()} - tipo poder ${tipo.poder}"
}

fun main(){
    val sableWindoo = SableDeLuz(TipoSable.MORADO, "WINDOO")
    println(sableWindoo)
    println(sableWindoo.activar())
    println(sableWindoo.info())

    val sableLuke = SableDeLuz(TipoSable.VERDE, "Luke Skywalker")
    println(sableLuke)
    println(sableLuke.activar())
    println(sableLuke.info())
}