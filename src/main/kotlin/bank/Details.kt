package bank

import user.Account
import employee.Employee

class Details(
  private val accounts: ArrayList<Account>?,
  private val employees: ArrayList<Employee>?,
) {

  fun getAccountsQuantities(): Int? = accounts?.size;


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