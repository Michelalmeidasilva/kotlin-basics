import employee.HeadManager
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

internal class HeadManagerTest {
  var employe: HeadManager? = null;

  @BeforeEach
  fun setUp() {
    employe = HeadManager(name= "Michel", salary= 10000.0, cpf="04051133079", password = "123234", profit = 900.0)
  }

  @AfterEach
  fun tearDown() {
    employe = null;
  }

  @Test
  fun getName() {
    assertEquals("Michel", employe?.name, "should have a name")
  }

  @Test
  fun getCpf() {
    assertEquals("04051133079", employe?.cpf, "should have a name")
  }


  @Test
  fun getCompensation() {
    assertEquals(null, employe?.compensation, "should have a null value")

  }

  @Test
  fun getBonuses() {
    assertEquals(3000.0, employe?.bonuses, "should have a 3000.0 value")
  }


  @Test
  fun getProfit() {
    assertEquals(900.0, employe?.profit, "should have a 900.0 value")
  }
}