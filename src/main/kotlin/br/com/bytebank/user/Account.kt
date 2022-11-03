package br.com.bytebank.user

open class Account(val titular: Client, val accountNumber: Int) {
  var balance: Double = 0.0
  open val taxes: Double = 0.0

  override fun toString(): String = "${titular}\t\t${accountNumber} \t\t${balance}"
}

