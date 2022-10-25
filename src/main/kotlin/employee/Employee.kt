package employee

abstract class Employee(
  var name: String,
  var cpf: String,
  val salary: Double,
  var compensation: Double? = null,
){
  abstract val bonuses: Double
  abstract val occupation: String
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