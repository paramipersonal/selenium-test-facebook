package authorization

trait LoginAuthorization {

  private val EMAIL_ID = "kolkatacovid19resources@gmail.com"
  private val PASSWORD = "Tom@4242"


  def getEmailId(): String = {
    EMAIL_ID
  }

  def getPassword(): String = {
    PASSWORD
  }

}
