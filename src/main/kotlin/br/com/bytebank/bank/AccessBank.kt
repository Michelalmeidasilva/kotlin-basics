package br.com.bytebank.bank

class AccessBank(private val objects: ArrayList<Authentication>?) {

  fun auth(login: String, password: String): Boolean{
    var isAuth = false


    objects?.forEach { it  -> if(it.password == password && it.login == login){
        isAuth = true
      }}



    return isAuth
  }
}
