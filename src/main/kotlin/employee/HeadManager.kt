package employee

class HeadManager(
  name: String,
  cpf: String,
  salary: Double,
  val profit: Double,
  password: String
): EmployeeWithAuthentication(name = name, cpf = cpf, salary = salary, password = password) {
  override val bonuses: Double get() = this.salary * 0.3
  override val ocupation: String = "HeadManager";
  override fun toString(): String {
    return "$name\t\t$cpf \t\t$salary \t$compensation \t$bonuses \t$profit \t$ocupation"
  }
}