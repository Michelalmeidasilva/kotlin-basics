import br.com.bytebank.user.Account
import br.com.bytebank.user.Client



// object declarator ( singleton )
object ContadorSingleton {
    var totalDeContas = 0

    fun incremment() {
        totalDeContas++
    }
}


class AccountTest {
    // companion object
    // se torna membro da classe
    companion object ContadorAcessible {
        var totalDeContas = 0
            private set
        private fun incremment() {
            totalDeContas++
        }
    }
}



fun main() {

    // Object expression
    val fran = object {
        var nome: String = "Fran"
        fun getTest(): String{
            return this.nome;
        }
    }

    ContadorSingleton.totalDeContas = 10
    ContadorSingleton.incremment()
    println(ContadorSingleton.totalDeContas);

    println(AccountTest.totalDeContas)
    println(fran.getTest())

    val test1 = Account(Client("michel1", "test1", "test1"), 8000);
    val test2 = Account(Client("michel2", "test2", "test2"), 10000);
    val test3 = Account(Client("michel3", "test3", "test3"), 12000);
    val test4 = Account(Client("michel4", "test4", "test4"), 14000);
    val test5 = Account(Client("michel5", "test5", "test5"), 16000);
}