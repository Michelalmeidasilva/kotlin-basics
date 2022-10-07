import java.math.BigDecimal

class Operations(private val accounts: ArrayList<Account>?) {

  private fun existsAccount(account: Account): Account? = accounts?.find { conta -> conta.accountNumber == account.accountNumber }

  fun create(account: Account) = this.existsAccount(account) ?: this.registerAccount(account)

  private fun registerAccount(account: Account) = accounts?.add(account);



  fun transferMoney(accountOrigin: Account, accountDestination: Account, amount: Double ): Boolean{
    if(existsAccount(accountOrigin) !== null && existsAccount(accountDestination) !== null){
      if(accountOrigin.balance >= amount ){
        accountOrigin.balance -= amount;
        accountDestination.balance += amount;
        return true;
      }
    }
    return false;
  }



  fun deposit(accountDestination: Account, amount: Double) {
    if (amount > 0.0) {
      accounts?.forEachIndexed { index, it ->
        if(accountDestination.accountNumber === it.accountNumber){
          it?.balance =+ amount;
        }
      }

    } else {
      throw Exception("Valor negativo para deposito não é permitido")
    }
  }


  fun withdraw(accountOrigin: Account, amount: Double){
    if(amount < 0) {
      throw Exception("Valor negativo para saque não é permitido")
    }

    if(accountOrigin.balance >= amount) {
      val value = BigDecimal(accountOrigin.balance) - BigDecimal(amount);
      accountOrigin.balance = value.toDouble();
    } else if(accountOrigin.balance < amount) {
      throw Exception("Não há esse valor na conta")
    }
  }
}