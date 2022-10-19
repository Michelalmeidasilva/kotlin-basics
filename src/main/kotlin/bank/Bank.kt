package bank

import employee.*
import user.Account

class Bank(var accounts: ArrayList<Account>? = ArrayList(), var employees: ArrayList<Employee>? = ArrayList()  ) {
  var filters: FilterAccounts? = null;
  var operations: Operations? = null;
  var details: Details? = null;
  var access: AccessBank? = null;

  init{
    if(accounts?.size!! > 1){
        accounts?.forEach {
          this.operations?.createAccount(it)
        }
      filters = FilterAccounts(accounts)
      operations = Operations(accounts)

      val usersWithAuth = employees?.filter{ it ->
        it is Supervisor || it is HeadManager
      }  as ArrayList<EmployeeWithAuthentication>;

      access = AccessBank(usersWithAuth)
      details = Details(accounts, employees);
    }
  }


  override fun toString(): String {
    val accountsString = accounts?.foldIndexed("Titular: \t Conta: \t Saldo: \t\n") {
        index, acc, account -> "$acc $index:${account.titular}\t\t${account.accountNumber} \t\t${account.balance}\n"
    };

    return accountsString ?: "";
  }
}
