package selenium

import utilities.common._

class LoginLogoutSpec extends BaseSpec {
  markup("This class contains tests to verify if login & logout works properly in facebook.")

  "Providing proper email id and password and logging in" should "log in to facebook successfully" in {
    withScreenshot {
      //The login method is not called here explicitly because it is invariably called at the start of each test class.
      //If login is performed successfully, the facebook home button should be present, in the next screen that appears.
      locateFacebookHome()
    }
  }

  "Clicking on Log out of Facebook" should  "log out of facebook successfully" in {
    withScreenshot{
      logOutOfFacebook()
      println("Logged out successfully.")
    }
  }

  "Trying to login with empty password" should "give password incorrect error " in {
    setPassword("")
    logInFacebook(driver,getEmailId(),getPassword())
    findPasswordIncorrectError()
  }
  
}