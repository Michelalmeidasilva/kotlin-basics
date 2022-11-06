package br.com.bytebank

import br.com.bytebank.user.Address
import java.lang.IllegalStateException


// object declarator ( singleton )
// valor estático e global

object ContadorSingleton {
    var totalDeContas = 0

    fun incremment() {
        totalDeContas++
    }
}


class AccountTest {
    // companion object valor estático
    // se torna membro da classe
    companion object ContadorAcessible {
        var totalDeContas = 0
            private set
        private fun incremment() {
            totalDeContas++
        }
    }
}

data class Person(val cpf: String, val name: String, val test: Address) {

}

fun main() {

    // Object expression
    val fran = object {
        var nome: String = "Fran"
        fun getTest(): String{
            return this.nome;
        }
    }





    val michel = Person("04053333", "Michel Silva",  Address("300", "Rua gomercino ferreira")  )
    val michel2 = michel.copy()
    val michel3 = michel.copy(cpf= "0340555555", name = "Amália")

    if(michel3 === michel){
        println("Diff")
    }

    if(michel == michel2){
        //desestructuring
        val (_,name, address, ) = michel2
        println(michel2.component3());
        println("$name\n$address")
    }

    var test: Address? = Address(address = "aaa");

    //safe call
    test?.let { it
        val valueTest: String? = null;
        val test = valueTest?.length ?: throw IllegalStateException("Error")
        println(test);
    }

//    br.com.bytebank.ContadorSingleton.totalDeContas = 10
//    br.com.bytebank.ContadorSingleton.incremment()
//    println(br.com.bytebank.ContadorSingleton.totalDeContas);
//
//    println(br.com.bytebank.AccountTest.totalDeContas)
//    println(fran.getTest())
//
//    val test1 = Account(Client("michel1", "test1", "test1"), 8000);
//    val test2 = Account(Client("michel2", "test2", "test2"), 10000);
//    val test3 = Account(Client("michel3", "test3", "test3"), 12000);
//    val test4 = Account(Client("michel4", "test4", "test4"), 14000);
//    val test5 = Account(Client("michel5", "test5", "test5"), 16000);
//
//    br.com.bytebank.customPrintln(Any())
}


fun customPrintln(value: Any?){
    println(value)
}