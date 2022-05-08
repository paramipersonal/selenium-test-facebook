package authorization

trait LoginAuthorization {

  private var EMAIL_ID = "kolkatacovid19resources@gmail.com"
  private var PASSWORD = "Tom@4242"


  def getEmailId(): String = {
    EMAIL_ID
  }

  def getPassword(): String = {
    PASSWORD
  }

  def setEmailId(emailId: String): Unit = {
    EMAIL_ID = emailId
  }

  def setPassword(password: String): Unit = {
    PASSWORD = password
  }

}
