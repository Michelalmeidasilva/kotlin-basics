package br.com.bytebank.user

import br.com.bytebank.user.*
import br.com.bytebank.bank.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import kotlin.test.DefaultAsserter
import kotlin.test.Test

class AccountTest {
  val bank = Bank()
  private val account = Account(Client("Michel", "10000", "test"), 1000)

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
    DefaultAsserter.assertEquals("Should has account name", "Michel", account.titular.name)
  }

  @Test
  fun shouldHasAccountNumber(){
    DefaultAsserter.assertEquals("Should has account number", 1000, account.accountNumber)
  }
}