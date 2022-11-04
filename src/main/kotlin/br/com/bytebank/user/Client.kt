package br.com.bytebank.user

import br.com.bytebank.bank.Authentication

class Client(val name: String, override val password: String, override val login: String, var address: Address = Address()): Authentication {
}