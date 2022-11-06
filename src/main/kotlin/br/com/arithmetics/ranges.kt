package br.com.arithmetics

fun main(){
  //ranges
  val rangeArray: IntProgression = 1.rangeTo(100)

  val numerosPares = 2..100 step 2;


  val numerosPares2 = 2.until(100) step 2;

  val numerosParesReverso = 100.downTo(0) step 2;

  numerosPares.forEach { it -> println(it) }
  numerosPares2.forEach { it -> println(it) }
  numerosParesReverso.forEach { it -> println(it) }


  val salario = 5000.0

  val intervalo = 1500.0..10000.0;

  if(salario in intervalo){
    println("Salario  de ${salario} está no intervalo de ${intervalo}")
  }

  val alfabeto = 'a'..'z'
  val letra = 'k'

  if(letra in alfabeto){
    println("letra ${letra} está no $alfabeto")
  }

}