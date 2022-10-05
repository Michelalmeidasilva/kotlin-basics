import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import kotlin.test.DefaultAsserter.assertEquals
import kotlin.test.Test

class BankTest {
  var bank: Bank? = null;


  @BeforeEach
  fun setUp() {

    val employees = arrayListOf(Employee("Inácio", "0303099342", 2000.0))
    val employeesSupervisors = arrayListOf(Supervisor("Juquinha", "0305099342", 8000.0,  "tfpw7erg"))
    val list: ArrayList<Account> = arrayListOf(Account("Michel Silva", 1000), Account("José Klaus", 2030))

    bank = Bank(employees = employees, accounts = list, employeesSupervisors = employeesSupervisors )
  }

  @AfterEach
  fun tearDown() {
  }


  @Test
  fun shouldHaveTwoAccounts() {
    assertEquals("Should be a list with two elements", 2, bank?.getAccountsQuantities())
  }


  @Test
  fun shouldSupervisorEmployeeLogin(){
    assertEquals("should pass with password tfpw7erg", true, bank?.auth("Juquinha", "tfpw7erg"))
  }


  @Test
  fun getAccountsQuantities() {
  }

  @Test
  fun create() {
  }

  @Test
  fun transferMoney() {
  }

  @Test
  fun testToString() {
  }

  @Test
  fun getAccounts() {
  }

  @Test
  fun setAccounts() {
  }


}