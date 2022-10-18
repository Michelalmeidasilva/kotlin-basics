 class AccessBank(private val employeesWithAuthentication: ArrayList<Supervisor>?) {

  fun auth(login: String, password: String): Boolean{
    var isAuth = false;

      employeesWithAuthentication?.forEach { it -> if(it.password == password && it.name == login){
        isAuth = true;
      }
    }

    return isAuth;
  }
}
