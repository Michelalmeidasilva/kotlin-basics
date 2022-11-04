package br.com.bytebank.user

class CheckingAccount(titular: Client, accountNumber: Int): Account(titular = titular, accountNumber = accountNumber){

  override val taxes = 0.1
}