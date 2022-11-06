import br.com.bytebank.bank.Bank
import br.com.bytebank.user.Account
import br.com.bytebank.user.Address
import br.com.bytebank.user.Client



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
    val michel2 = Person("04053333", "Michel Silva",  Address("300", "Rua gomercino ferreira")  )

    if(michel == michel2){
        println(michel);
    }

//
//    ContadorSingleton.totalDeContas = 10
//    ContadorSingleton.incremment()
//    println(ContadorSingleton.totalDeContas);
//
//    println(AccountTest.totalDeContas)
//    println(fran.getTest())
//
//    val test1 = Account(Client("michel1", "test1", "test1"), 8000);
//    val test2 = Account(Client("michel2", "test2", "test2"), 10000);
//    val test3 = Account(Client("michel3", "test3", "test3"), 12000);
//    val test4 = Account(Client("michel4", "test4", "test4"), 14000);
//    val test5 = Account(Client("michel5", "test5", "test5"), 16000);
//
//    customPrintln(Any())
}


fun customPrintln(value: Any?){
    println(value)
}