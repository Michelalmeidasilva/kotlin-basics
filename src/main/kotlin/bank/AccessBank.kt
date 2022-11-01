package bank

import employee.Authentication

class AccessBank(private val employeesWithAuthentication: ArrayList<Authentication>?) {

  fun auth(login: String, password: String): Boolean{
    var isAuth = false

    employeesWithAuthentication?.forEach { it  -> if(it.password == password && it.login == login){
      isAuth = true
    }}


    return isAuth
  }
}
