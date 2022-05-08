package selenium

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import utilities.common._

class LoginLogoutSpec extends BaseSpec {
  markup("This class contains test to check that facebook logs out properly")

  "Providing proper email id and password and logging in" should "log in to facebook successfully" in {
    explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(s"//a[contains(@aria-label,'Home')]")))
  }

  "Clicking on Log out of Facebook" should  "log out of facebook successfully" in {
    withScreenshot{
      logOutOfFacebook()
      println("Logged out successfully.")
    }
  }

  "Trying to login with wrong password" should "give password incorrect error " in {
    setPassword("")
    logInFacebook(driver,getEmailId(),getPassword())
    explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href*='facebook_login_pw_error']")))
  }
  
}