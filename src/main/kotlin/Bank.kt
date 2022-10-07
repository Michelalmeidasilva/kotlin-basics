import java.math.BigDecimal

class Bank(var accounts: ArrayList<Account>? = ArrayList(), var employees: ArrayList<Employee>? = ArrayList(), var employeesSupervisors: ArrayList<Supervisor>? = ArrayList()) {

  init{
    if(accounts?.size!! > 1){
        accounts?.forEach {
          this.create(it)
        }
    }
  }

  fun depositMoney(accountDestination: Account, amount: Double) {
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

  fun filterAccountByNumber(number: Int): List<Account>? {
    return accounts?.filter { it -> it?.accountNumber == number }
  }

  fun filterAccountByName(titular: String): List<Account>? {
    return accounts?.filter { it -> it?.titular == titular }
  }

  fun auth(login: String, password: String): Boolean{
    var isAuth = false;

    employeesSupervisors?.forEach { it -> if(it.password == password && it.name == login){
      isAuth = true;
      }
    }

    return isAuth;
  }

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

  fun getAccountsQuantities(): Int?{
    return accounts?.size;
  }

  fun create(account: Account) = this.existsAccount(account) ?: this.registerAccount(account)

  private fun existsAccount(account: Account): Account? = accounts?.find { conta -> conta.accountNumber == account.accountNumber }

  private fun registerAccount(account: Account) = accounts?.add(account);

  override fun toString(): String {
    val accountsString = accounts?.foldIndexed("Titular: \t Conta: \t Saldo: \t\n") {
        index, acc, account -> "$acc $index:${account.titular}\t\t${account.accountNumber} \t\t${account.balance}\n"
    };

    return accountsString ?: "";
  }
}
