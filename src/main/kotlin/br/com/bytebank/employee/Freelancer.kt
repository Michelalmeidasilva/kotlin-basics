package br.com.bytebank.employee

class Freelancer(name: String, override val occupation: String, override val bonuses: Double, salary: Double, cpf: String): Employee(name, cpf, salary, 10.0){

}