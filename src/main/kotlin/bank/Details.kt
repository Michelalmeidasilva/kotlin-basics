package bank

import user.Account
import employee.Employee

class Details(
  private val accounts: ArrayList<Account>?,
  private val employees: ArrayList<Employee>?,
) {

  fun getAccountsQuantities(): Int? = accounts?.size;


  fun reportAccounts(): String {
    val accountsString = accounts?.foldIndexed("Titular: \t Conta: \t Saldo: \t\n") {
        index, acc, account -> "$acc $index: ${account.toString()}\n"
    };

    return accountsString ?: "";
  }

  fun reportEmployee(): String {
    val employeeString = employees?.foldIndexed("") {
        index, acc, employee -> "$acc $index: ${employee.toString()}\n"
    };

    return employeeString ?: "";
  }

  /**
   *
   * Refatorar para polimorfismo
   */
  fun getAllBonuses(): Double? {
    var allValues = 0.0;

    allValues = employees?.fold(0.0){ acc, curr -> acc + curr.bonuses }!!;

    return allValues;
  }
}