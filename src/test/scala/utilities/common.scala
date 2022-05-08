package utilities

import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}


object common {

  val facebookLink : String = "https://www.facebook.com/"
  val captureDirectory: String = "screenshots"
  var explicitWait: WebDriverWait = _
  implicit var driver: WebDriver = _
  val chromeOptions = new ChromeOptions()
  chromeOptions.addArguments("--disable-notifications")


  def logInFacebook(driver: WebDriver,email: String, password: String): Unit = {
    launchFacebook(driver)
    checkIfEmailFieldIsPresent()
    checkIfPasswordFieldIsPresent()
    inputEmailIdAndPassWord(email, password)
    clickLoginButton()
  }

  def launchFacebook(driver: WebDriver): Unit = {
    driver.get(facebookLink)
    explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")))
    driver.manage().window().maximize()
  }


  def clickLoginButton(): Unit = {
    val loginButton = explicitWait.until(ExpectedConditions.elementToBeClickable(By.name("login")))
    loginButton.click()
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
    clickAccountDropdown()
    //This line is temporary
    //explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div/div[1]/div[1]/div/div[1]/span/div/div[2]"))).click()
    explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(s"//span[.='See your profile']")))
    val logout = explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(s"//span[.='Log Out']")))
    logout.click()
    explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")))
  }

  def locateFacebookHome(): WebElement = {
    val home = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(s"//a[contains(@aria-label,'Home')]")))
    home
  }
  def clickFacebookHome(): Unit = {
    val home = locateFacebookHome()
    home.click()
    explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(s"//div[contains(@aria-label,'Create a post')]")))
  }

  def clickAccountDropdown(): Unit = {
    explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(s"//div[contains(@aria-label,'Your profile')]"))).click()
  }

  def goToTimeline(): Unit = {
     clickAccountDropdown()
    //This line is temporary
    //explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div/div[1]/div[1]/div/div[1]/span/div/div[2]"))).click()
    explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/me/']"))).click()
    explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[.='Photos']")))
  }

  def scrollDown(pixel: String): Unit = {
    val js = driver.asInstanceOf[JavascriptExecutor]
    js.executeScript(pixel, "")
  }

  def findPasswordIncorrectError(): Unit = {
    explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href*='facebook_login_pw_error']")))
  }

}
