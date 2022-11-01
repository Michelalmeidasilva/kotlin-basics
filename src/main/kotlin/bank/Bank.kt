package bank

import employee.*
import user.Account

class Bank(var accounts: ArrayList<Account>? = ArrayList(), var employees: ArrayList<Employee>? = ArrayList()) {
  var filters: FilterAccounts? = null
  var operations: Operations? = null
  var details: Details? = null
  var access: AccessBank? = null

  init{
    if( employees != null) {
      val usersWithAuth = employees?.filter{ it ->
        it is Supervisor || it is HeadManager
      }  as ArrayList<Authentication>

      access = AccessBank(usersWithAuth)
    }

    if(employees != null && accounts != null) {
      details = Details(accounts, employees)
    }

    if(accounts != null){
        accounts!!.forEach {
          this.operations?.createAccount(it)
        }
      filters = FilterAccounts(accounts)
      operations = Operations(accounts)
    }
  }
}
