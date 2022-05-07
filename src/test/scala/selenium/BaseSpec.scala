package selenium

import authorization._
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.selenium.WebBrowser
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}

abstract class BaseSpec() extends AnyFlatSpec with Matchers with BeforeAndAfterAll with WebBrowser with LoginAuthorization {

  val chromeOptions = new ChromeOptions()
  chromeOptions.addArguments("--disable-notifications")
  implicit var driver: WebDriver = _
  var chromeDriver: String = _
  val facebookLink : String = "https://www.facebook.com/"
  var explicitWait: WebDriverWait = _



  override def beforeAll(): Unit = {
    driver = new ChromeDriver(chromeOptions)
    chromeDriver = System.setProperty("webdriver.chrome.driver","chromedriver")
    explicitWait = new WebDriverWait(driver,30,100)
    //val email = "kolkatacovid19resources@gmail.com"
    //val password = "Tom@4242"
    logInFacebook(driver,getEmailId(),getPassword())
  }

  override def afterAll(): Unit = {
    driver.close()
  }

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
    explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(s"//div[contains(@aria-label,'Your profile')]"))).click()
    explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(s"//span[.='See your profile']")))
    val logout = explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(s"//span[.='Log Out']")))
    logout.click()
    explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")))

  }


}