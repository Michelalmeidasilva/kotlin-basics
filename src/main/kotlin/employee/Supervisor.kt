package employee

class Supervisor(
  name: String,
  cpf: String,
  salary: Double,
  override val password: String,
  override val login: String = name
): Employee(name = name, cpf = cpf, salary = salary) , Authentication {
  override val bonuses: Double get() = this.salary * 0.2
  override val occupation: String = "Supervisor"
  override fun toString(): String {
    return "$name\t\t$cpf \t\t$salary \t$compensation \t$bonuses \t$occupation"
  }
}