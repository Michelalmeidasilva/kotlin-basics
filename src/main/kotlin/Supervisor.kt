class Supervisor(
  name: String,
  cpf: String,
  salary: Double,
  val password: String
): Employee(name = name, cpf = cpf, salary = salary) {

  override val bonuses: Double get() = this.salary * 0.2


}