package user

class CheckingAccount(titular: String, accountNumber: Int): Account(titular = titular, accountNumber = accountNumber) {
  override val taxes = 0.1
}