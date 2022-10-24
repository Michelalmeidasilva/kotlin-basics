package employee

open class Employee(
  var name: String,
  var cpf: String,
  val salary: Double,
  var compensation: Double? = null,
){
  open val bonuses: Double  get() = salary * 0.1
  open val occupation: String = "Employee"

  override fun toString(): String {
    return "$name\t\t$cpf \t\t$salary \t$compensation \t$bonuses\t$occupation"
  }
}


/**
  Compensation is:
  Commissions Tuition assistance

  Insurance (medical, dental, disability and/or life)
  Profit-sharing distributions
  Childcare assistance

  Paid time off (vacation days, sick days and holidays)
  Retirement plans

  employee.Employee assistance programs that offer legal advice, counseling and other services
  Gym memberships
 */