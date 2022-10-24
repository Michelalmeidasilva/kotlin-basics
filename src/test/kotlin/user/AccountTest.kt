import bank.Bank
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import user.Account
import kotlin.test.DefaultAsserter
import kotlin.test.Test

class AccountTest {
  val bank = Bank();
  private val account = Account("Michel", 10000)

  @BeforeEach
  fun setUp() {
    bank.accounts = arrayListOf(account)
  }

  @AfterEach
  fun tearDown() {
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
}