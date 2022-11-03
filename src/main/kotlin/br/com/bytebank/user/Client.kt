package br.com.bytebank.user

import br.com.bytebank.bank.Authentication

class Client(override val password: String, override val login: String): Authentication {
}