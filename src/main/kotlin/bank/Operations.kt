package bank

import user.Account
import java.math.BigDecimal

class Operations(private val accounts: ArrayList<Account>?) {
  fun createAccount(account: Account) = this.existsAccount(account) ?: this.registerAccount(account)

  private fun existsAccount(account: Account): Account? = accounts?.find { personAccount -> personAccount.accountNumber == account.accountNumber }


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
      accounts?.forEach{ it ->
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