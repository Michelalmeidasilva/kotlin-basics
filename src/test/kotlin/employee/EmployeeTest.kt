package employee

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class EmployeeTest {
  var employe: Employee? = null

  @BeforeEach
  fun setUp() {
    employe = Supervisor(name= "Michel", salary= 1000.0, cpf="04051133079", password = "test")
  }

  @AfterEach
  fun tearDown() {
    employe = null
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
    assertEquals(200.0, employe?.bonuses, "should have a 100.0 value")
  }
}