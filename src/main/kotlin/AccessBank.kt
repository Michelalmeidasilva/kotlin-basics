public class AccessBank(val employeesWithAuthenticaiton: ArrayList<Supervisor>?) {

  fun auth(login: String, password: String): Boolean{
    var isAuth = false;

      employeesWithAuthenticaiton?.forEach { it -> if(it.password == password && it.name == login){
        isAuth = true;
      }
    }

    return isAuth;
  }
}
