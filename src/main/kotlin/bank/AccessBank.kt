package bank

import employee.EmployeeWithAuthentication

class AccessBank(private val employeesWithAuthentication: ArrayList<EmployeeWithAuthentication>?) {

  fun auth(login: String, password: String): Boolean{
    var isAuth = false;

    employeesWithAuthentication?.forEach { it  -> if(it.password == password && it.name == login){
      isAuth = true;
    }}


    return isAuth;
  }
}
