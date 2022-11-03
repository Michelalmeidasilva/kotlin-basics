package br.com.bytebank.employee

class SoftwareDeveloper(
  name: String,
  cpf: String,
  salary: Double,
  val profit: Double
): Employee(name = name, cpf = cpf, salary = salary) {
  override val bonuses: Double get() = this.salary * 0.1
  override val occupation: String = "Software Developer"
  override fun toString(): String {
    return "$name\t\t$cpf \t\t$salary \t$compensation \t$bonuses \t$profit \t$occupation"
  }
}