class Supervisor(
  name: String,
  cpf: String,
  salary: Double,
  val password: String
): Employee(name = name, cpf = cpf, salary = salary) {

  override fun getBonuses(): Double{
    return this.salary * 0.2
  }

}