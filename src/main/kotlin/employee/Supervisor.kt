package employee

class Supervisor(
  name: String,
  cpf: String,
  salary: Double,
  password: String
): EmployeeWithAuthentication(name = name, cpf = cpf, salary = salary, password = password) {
  override val bonuses: Double get() = this.salary * 0.2
}