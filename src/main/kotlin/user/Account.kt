package user

class Account(val titular: String, val accountNumber: Int) {
  var balance: Double = 0.0

  override fun toString(): String = "$titular - $accountNumber  - $balance";
}

