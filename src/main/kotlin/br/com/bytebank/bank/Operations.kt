package br.com.bytebank.bank

import br.com.bytebank.user.*
import java.math.BigDecimal

class Operations(private val accounts: ArrayList<Account>?) {
  fun createAccount(account: Account) = this.existsAccount(account) ?: this.registerAccount(account)

  private fun existsAccount(account: Account): Account? = accounts?.find { personAccount -> personAccount.accountNumber == account.accountNumber }


  private fun registerAccount(account: Account) = accounts?.add(account)

  fun transferMoney(accountOrigin: Account, accountDestination: Account, amount: Double ): Boolean{
    if(existsAccount(accountOrigin) !== null && existsAccount(accountDestination) !== null){
      if(accountOrigin.balance >= amount ){
        accountOrigin.balance -= amount
        accountDestination.balance += amount
        return true
      }
    }
    return false
  }

  fun deposit(accountDestination: Account?, amount: Double){
    if (amount > 0.0) {
      val accountIndex = isAValidAccount(accountDestination)

      if(accountIndex != null && accounts?.get(accountIndex)!= null) {
        accounts[accountIndex].balance =+ amount + accounts[accountIndex].taxes
      }
    } else {
      throw Exception("Valor negativo para deposito não é permitido")
    }
  }

  private fun isAValidAccount(account: Account?): Int? {
    var indexAccount: Int? = null
     accounts?.forEachIndexed { index, it ->
       if(      account?.accountNumber == it.accountNumber){
         indexAccount = index
       }
    }

    return indexAccount
  }



  fun withdraw(accountOrigin: Account, amount: Double){
    if(amount < 0) {
      throw Exception("Valor negativo para saque não é permitido")
    }

    if(accountOrigin.balance >= amount) {
      val value = BigDecimal(accountOrigin.balance) - BigDecimal(amount)
      accountOrigin.balance = value.toDouble()
    } else {
      throw Exception("Não há esse valor na conta")
    }
  }
}