package selenium

import utilities.common._

class LoginSpec extends BaseSpec {
  markup("This test will launch facebook and login")

  "Clicking on Log out of Facebook" should  "log out of facebook successfully" in {
    logOutOfFacebook()
    println("Logged out successfully.")
  }


}