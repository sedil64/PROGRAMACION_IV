package com.example.basics
fun main(){
    try{
        val resultado= 8/0;
    }catch (e: Exception){
        println(e)
        println("Error en division ")
    }
}