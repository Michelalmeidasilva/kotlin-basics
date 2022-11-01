package employee

class HeadManager(
  name: String,
  cpf: String,
  salary: Double,
  val profit: Double,
  override val password: String,
  override val login: String = name
): Employee(name = name, cpf = cpf, salary = salary), Authentication {
  override val bonuses: Double get() = this.salary * 0.3
  override val occupation: String = "HeadManager"
  override fun toString(): String {
    return "$name\t\t$cpf \t\t$salary \t$compensation \t$bonuses \t$profit \t$occupation"
  }
}