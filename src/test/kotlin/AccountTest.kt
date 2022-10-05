import kotlin.test.DefaultAsserter
import kotlin.test.Test
import kotlin.test.assertFailsWith

class AccountTest {
  private val account = Account("Michel", 10000)

  @Test
  fun shouldBeBalanceEvaluated(){
    account.deposit(1000.0);
    DefaultAsserter.assertEquals("Should have 1 thousand balance", 1000.0, account.balance)
  }

  @Test
  fun shouldBeBalanceZero(){
    DefaultAsserter.assertEquals("Should have balance zero", 0.0, account.balance)
  }

  @Test
  fun shouldHasAccountName(){
    DefaultAsserter.assertEquals("Should has account name", "Michel", account.titular)
  }

  @Test
  fun shouldHasAccountNumber(){
    DefaultAsserter.assertEquals("Should has account number", 10000, account.accountNumber)
  }

  @Test
  fun shouldHaveASuccessToDeposited(){
    account.deposit(300.0)
    DefaultAsserter.assertEquals("Should has account number", 300.0,account.balance )
  }

  @Test
  fun shouldHaveASuccessToWithdrew(){
    account.deposit(300.0);
    account.withdraw(300.0)
    DefaultAsserter.assertEquals("Should have withdrew", 0.0,account.balance )
  }

  @Test
  fun shouldHaveASuccessToWithdrewWithDecimalDifferences(){
    account.deposit(300.01);
    account.withdraw(300.001)
    DefaultAsserter.assertEquals("Should have withdrew", 0.009,account.balance )
  }


  @Test()
  fun shouldNotWithdraw(){
    val exception = assertFailsWith<Exception> {account.withdraw(1000.0)}
    DefaultAsserter.assertEquals("Should be a error","Não há esse valor na conta", exception.message )
  }

  @Test
  fun shouldNotDeposit(){
    val exception = assertFailsWith<Exception> {account.deposit(-31000.0)}
    DefaultAsserter.assertEquals("Shouldnt withdraw, is not allowed deposit negative value", "Valor negativo para deposito não é permitido", exception.message )
  }

}