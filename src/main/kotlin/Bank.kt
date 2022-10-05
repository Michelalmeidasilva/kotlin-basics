class Bank(var accounts: ArrayList<Account>? = ArrayList(), var employees: ArrayList<Employee>? = ArrayList(), var employeesSupervisors: ArrayList<Supervisor>? = ArrayList()) {

  init{

    if(accounts?.size!! > 1){
        accounts?.forEach {
          this.create(it)
        }
    }
  }

  fun auth(login: String, password: String): Boolean{
    var isAuth = false;

    employeesSupervisors?.forEach { it -> if(it.senha == password && it.name == login){
      isAuth = true;
      }
    }

    return isAuth;
  }

  fun transferMoney(accountOrigin: Account, accountDestination: Account, amount: Double ): Boolean{
    if(existsAccount(accountOrigin) !== null && existsAccount(accountDestination) !== null){
      if(accountOrigin.balance >= amount ){
        accountOrigin.withdraw(amount);
        accountDestination.deposit(amount);
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
