package selenium

import utilities.common._

class LogoutSpec extends BaseSpec {
  markup("This class contains test to check that facebook logs out properly")

  "Clicking on Log out of Facebook" should  "log out of facebook successfully" in {
    withScreenshot{
      logOutOfFacebook()
      println("Logged out successfully.")
    }
  }
  
}