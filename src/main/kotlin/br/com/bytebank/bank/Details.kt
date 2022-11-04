package br.com.bytebank.bank

import br.com.bytebank.employee.*
import br.com.bytebank.user.*

class Details(
  private val accounts: ArrayList<Account>?,
  private val employees: ArrayList<Employee>?,
) {
  val log = object {
    var starts: String = "date start"
    var ends: String = "date ends"
    var text: String = "text"
  }
  fun getAccountsQuantities(): Int? = accounts?.size

  fun reportAccounts(): String {
    val accountsString = accounts?.foldIndexed("Titular: \t Conta: \t Saldo: \t\n") {
        index, acc, account -> "$acc $index: $account\n"
    }

    return accountsString ?: ""
  }

  fun reportEmployee(): String {
    val employeeString = employees?.foldIndexed("") {
        index, acc, employee -> "$acc $index: $employee\n"
    }

    return employeeString ?: ""
  }

  fun getAllBonuses(): Double {
    return employees?.fold(0.0) { acc, curr -> acc + curr.bonuses }!!
  }
}