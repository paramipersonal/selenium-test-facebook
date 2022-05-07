package selenium

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions

class LoginSpec extends BaseSpec {
  markup("This test will launch facebook and login")

  "Clicking on Log out of Facebook" should  "log out of facebook successfully" in {
    logOutOfFacebook()
    println("Logged out successfully.")
  }


}