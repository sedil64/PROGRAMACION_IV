package com.example.basics

fun main(){
    println("Listas")

    val inmutable: List<Int> = listOf(1,2,3)
    println("Lista inmutable ${inmutable}")

    val mutableLista: MutableList<Int> =mutableListOf(4,5,6)
    println("Lista mutable ${mutableLista}")
    mutableLista.add(7)
    println("Lista Mutable ${mutableLista}")
    mutableLista.removeAt(index = 0)
    println("Lista Mutable ${mutableLista}")

    for(mutable in mutableLista) println(mutable)


    println("Operaciones con mutable list")

    val colores = mutableListOf("rojo","verde")
    colores.add("azul")
    colores+="amarillo"
    colores.add( index = 1, "blanco")

    println(colores)
    colores.remove(element = "verde")
    println(colores)
    colores.removeAt(index = 0)
    println(colores)
    colores[0]="negro"
    println(colores)
    colores.clear()
    println(colores.isEmpty())

    println("Busquedad con Mutable list")
    val nombres = mutableListOf("juan", "luis", "pedro")
    println(nombres.find {it.startsWith( "L")})
    println(nombres.firstOrNull() {it.length>4})
    println(nombres.any {it.contains('j')})
    println(nombres.none {it =="X"} )

    println("Ordenamiento con Mutable list")
    val numerosDesordenados = mutableListOf(8,3,2,4,7,2,7,0,6)
    println(numerosDesordenados.sorted())
    println(numerosDesordenados.sortedDescending())
    println(numerosDesordenados.distinct())







}