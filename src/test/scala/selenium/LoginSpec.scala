package selenium

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.{ExpectedCondition, ExpectedConditions}

class LoginSpec extends BaseSpec {

  markup("This test will launch facebook and login")

  private val EMAIl_ID = "kolkatacovid19resources@gmail.com"
  private val PASSWORD = "Tom@4242"

  "Calling the facebook Link" should "launch facebook properly" in {
    launchFacebook(driver)
    checkIfEmailFieldIsPresent()
    checkIfPasswordFieldIsPresent()
  }

  "Putting in proper email and password" should "log in to facebook properly" in {
    driver.get(facebookLink)
    Thread.sleep(2000)
    inputEmailIdAndPassWord(EMAIl_ID,PASSWORD)
    clickLoginButton()
    logOutOfFacebook()
    println("Logged out successfully.")
  }


  def clickLoginButton(): Unit = {
    val loginButton = explicitWait.until(ExpectedConditions.elementToBeClickable(By.name("login")))
    loginButton.click()
    Thread.sleep(2000)
    explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(s"//div[contains(@aria-label,'Facebook')]")))
  }


  def inputEmailIdAndPassWord (email: String,password: String): Unit = {
    val emailInputField = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")))
    emailInputField.sendKeys(email)
    val passwordInputField = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass")))
    passwordInputField.sendKeys(password)
  }


  def checkIfEmailFieldIsPresent(): Unit = {
    println("I am checking if email field is present properly.")
    assert(driver.findElement(By.id("email")).isDisplayed)
  }

  def checkIfPasswordFieldIsPresent(): Unit = {
    println("I am checking if password field is present properly.")
    assert(driver.findElement(By.id("pass")).isDisplayed)
  }

  def logOutOfFacebook(): Unit = {
    explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(s"//div[contains(@aria-label,'Your profile')]"))).click()
    explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(s"//span[.='See your profile']")))
    val logout = explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(s"//span[.='Log Out']")))
    logout.click()
    explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")))

  }
}