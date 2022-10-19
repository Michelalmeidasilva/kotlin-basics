package employee

open class EmployeeWithAuthentication(
  name: String,
  cpf: String,
  salary: Double,
  val password: String
): Employee(name = name, cpf = cpf, salary = salary) {
}