class Details(private val accounts: ArrayList<Account>?) {

  fun getAccountsQuantities(): Int? = accounts?.size;

}