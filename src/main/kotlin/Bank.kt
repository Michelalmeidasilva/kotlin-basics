class Bank(var accounts: ArrayList<Account>? = ArrayList(), var employees: ArrayList<Employee>? = ArrayList(), var employeesSupervisors: ArrayList<Supervisor>? = ArrayList()) {
  var filters: FilterAccounts? = null;
  var operations: Operations? = null;
  var details: Details? = null;
  var access: AccessBank? = null;

  init{
    if(accounts?.size!! > 1){
        accounts?.forEach {
          this.operations?.create(it)
        }
      filters = FilterAccounts(accounts)
      operations = Operations(accounts)
      access = AccessBank(employeesSupervisors)
      details = Details(accounts)
    }
  }


  override fun toString(): String {
    val accountsString = accounts?.foldIndexed("Titular: \t Conta: \t Saldo: \t\n") {
        index, acc, account -> "$acc $index:${account.titular}\t\t${account.accountNumber} \t\t${account.balance}\n"
    };

    return accountsString ?: "";
  }
}
