import java.math.BigDecimal

class Account(val titular: String,  val accountNumber: Int) {
  var balance: Double = 0.0
    private set

  fun deposit(amount: Double ) {
    if (amount > 0.0) {
      this.balance = this.balance + amount;
    } else {
      throw Exception("Valor negativo para deposito não é permitido")
    }
  }

  fun withdraw(amount: Double){
    if(this.balance >= amount) {
      val value = BigDecimal(this.balance) - BigDecimal(amount);
      this.balance = value.toDouble();
    }
    else {
      throw Exception("Não há esse valor na conta")
    }
  }

  override fun toString(): String = "$titular - $accountNumber  - $balance";
}

