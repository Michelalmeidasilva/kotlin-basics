class HeadManager(
  name: String,
  cpf: String,
  salary: Double,
  val password: String,
  val profit: Double,
): Employee(name = name, cpf = cpf, salary = salary) {
  override val bonuses: Double get() = this.salary * 0.3
}