
import br.com.bytebank.bank.*
import br.com.bytebank.employee.*
import br.com.bytebank.user.*

import org.junit.jupiter.api.BeforeEach
import kotlin.test.*
import kotlin.test.DefaultAsserter.assertEquals

class BankTest {
  var bank: Bank? = null

  @BeforeEach
  fun setUp(){
    val employees = arrayListOf<Employee>(
      SoftwareDeveloper("Inácio", "0303099342", 2000.0, 30.0), Supervisor("Claudio", "0305049342", 6000.0,  "tfpw7erg"),
      HeadManager("Juquinha", "0305099342", 8000.0,   399.0, "tfpw10erg") )

    val list: ArrayList<Account> = arrayListOf(DepositAccount(Client("Michel Silva", "michelsilva234", "michel"), 1000, ), DepositAccount(Client("José Klaus", "2030", "test"), 2030), CheckingAccount(Client("Robson Juventude", "2056", "testsd"), 300 ),  CheckingAccount(Client("Joao milao", "2055", "dadada"), 4000))
    bank = Bank(employees = employees, accounts = list )

    bank?.operations?.deposit(list.get(0),1000.0)
  }

  @Test
  fun shouldHaveTwoAccounts() {
    assertEquals("Should be a list with four elements", 4, bank?.details?.getAccountsQuantities())
  }

  @Test
  fun shouldSupervisorEmployeeLogin(){
    assertEquals("should pass with password tfpw7erg", true, bank?.access?.auth("Juquinha", "tfpw10erg"))
  }

  @Test
  fun transferMoneyDestinationAccount() {
    val michel = bank?.accounts?.find { it -> it.accountNumber == 1000 }
    val jose = bank?.accounts?.find {it -> it.accountNumber == 2030}

    if (michel != null && jose != null) {
      bank?.operations?.transferMoney(michel, jose, 300.0)
    }

    assertEquals("should have 300 at jose account ", 300.0, bank?.accounts?.find { it -> it.accountNumber == 2030 }?.balance)
  }

  @Test
  fun transferMoneyOriginAccount() {
    val michel = bank?.accounts?.find { it -> it.accountNumber == 1000 }
    val jose = bank?.accounts?.find {it -> it.accountNumber == 2030}

    if (michel != null && jose != null) {
      bank?.operations?.transferMoney(michel, jose, 300.0)
    }

    assertEquals("should have 700 at michel account ", 700.0, bank?.accounts?.find { it -> it.accountNumber == 1000 }?.balance)
  }

  @Test
  fun shouldHaveASuccessToDeposited(){
    val michel = bank?.accounts?.find { it -> it.accountNumber == 1000 }

    if (michel != null) {
      bank?.operations?.deposit(michel,4000.0)
    }

    DefaultAsserter.assertEquals("Should has account number", 4000.0, bank?.filters?.byAccountNumber(1000)?.get(0)?.balance )
  }

  @Test
  fun shouldHaveASuccessToWithdrew(){

    val michel = bank?.accounts?.find { it -> it.accountNumber == 1000 }

    if (michel != null) {
      bank?.operations?.withdraw(michel, 300.0)
    }

    DefaultAsserter.assertEquals("Should have withdrew",700.0, bank?.filters?.byAccountNumber(1000)?.get(0)?.balance )
  }

  @Test
  fun shouldHaveASuccessToWithdrewWithDecimalDifferences(){
    val michel = bank?.accounts?.find { it -> it.accountNumber == 1000 }

    if (michel != null) {
      bank?.operations?.withdraw(michel, 300.001)
    }

    DefaultAsserter.assertEquals("Should have withdrew", 699.999,bank?.filters?.byAccountNumber(1000)?.get(0)?.balance )
  }


  @Test()
  fun shouldNotWithdraw(){
    val michel = bank?.accounts?.find { it -> it.accountNumber == 1000 }


    val exception = assertFailsWith<Exception> {
      if (michel != null) {
        bank?.operations?.withdraw(michel, 3000.0)
      }
    }

    DefaultAsserter.assertEquals("Should be a error","Não há esse valor na conta", exception.message )

  }

  @Test
  fun shouldNotWithdrawNegativeValues(){
    val michel = bank?.accounts?.find { it -> it.accountNumber == 1000 }

    val exception = assertFailsWith<Exception> {
      if (michel != null) {
        bank?.operations?.withdraw(michel, -30000.0)
      }
    }

    DefaultAsserter.assertEquals("Shouldnt withdraw, is not allowed withdraw negative value", "Valor negativo para saque não é permitido", exception.message )
  }

  @Test
  fun shouldNotDepositNegativeValues(){
    val michel = bank?.accounts?.find { it -> it.accountNumber == 1000 }

    val exception = assertFailsWith<Exception> {
      if (michel != null) {
        bank?.operations?.deposit(michel, -30000.0)
      }
    }

    DefaultAsserter.assertEquals("Shouldnt deposite, is not allowed deposite negative value", "Valor negativo para deposito não é permitido", exception.message )
  }


  @Test
  fun shouldHaveAValueWithAllBonusesFromEmployees(){
    DefaultAsserter.assertEquals("Should return a value with all bonuses",3800.0, bank?.details?.getAllBonuses() )
  }

  @Test
  fun shouldReportAllAccountsCreated(){
    println(bank?.details?.reportAccounts())
    DefaultAsserter.assertNotNull("Should have a string to report account",bank?.details?.reportAccounts() )
  }

  @Test
  fun shouldReportAllEmployeesCreated(){
    println(bank?.details?.reportEmployee())
    DefaultAsserter.assertNotNull("Should have a string to report account",bank?.details?.reportEmployee() )
  }

  @Test
  fun shouldDepositMoneyWithCheckingAccount(){
    val robson = bank?.accounts?.find { it -> it.accountNumber == 300 }

    if(robson != null) {
      bank?.operations?.deposit(robson, 4000.0)
    }

    DefaultAsserter.assertEquals("Should has deposit a value to checking account", 4000.1, bank?.filters?.byAccountNumber(300)?.get(0)?.balance )

  }

}