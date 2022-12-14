package br.com.bytebank.bank

import br.com.bytebank.user.Account

class FilterAccounts(private val list: ArrayList<Account>?) {
  fun byAccountNumber(number: Int): List<Account>? = this.list?.filter { it -> it?.accountNumber == number }
  fun byAccountName(titular: String): List<Account>? = this.list?.filter { it -> it?.titular.name == titular }

}