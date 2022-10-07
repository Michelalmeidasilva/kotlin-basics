class FilterAccounts(private val list: ArrayList<Account>?) {
  fun byAccountNumber(number: Int): List<Account>? {
    return this.list?.filter { it -> it?.accountNumber == number }
  }

  fun byAccountName(titular: String): List<Account>? {
    return this.list?.filter { it -> it?.titular == titular }
  }
}