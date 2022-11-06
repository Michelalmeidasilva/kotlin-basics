package br.com.bytebank.employee

abstract class Employee(
  var name: String,
  var cpf: String,
  val salary: Double,
  var compensation: Double? = null,
){


  abstract val bonuses: Double
  abstract val occupation: String

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as Employee

    if (name != other.name) return false
    if (cpf != other.cpf) return false

    return true
  }

  override fun hashCode(): Int {
    var result = name.hashCode()
    result = 31 * result + cpf.hashCode()
    return result
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