package selenium

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.selenium.WebBrowser
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait, Wait, WebDriverWait}

abstract class BaseSpec extends AnyFlatSpec with Matchers with BeforeAndAfterAll with WebBrowser{

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
  }

  override def afterAll(): Unit = {
    driver.close()
  }

  def launchFacebook(driver: WebDriver): Unit = {
    driver.get(facebookLink)
    explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")))
    driver.manage().window().maximize()
  }


}