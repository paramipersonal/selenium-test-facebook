package selenium

import authorization._
import org.openqa.selenium.chrome.ChromeDriver
import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.selenium.WebBrowser
import utilities.common._
import org.openqa.selenium.support.ui.WebDriverWait

abstract class BaseSpec() extends AnyFlatSpec with Matchers with BeforeAndAfterAll with WebBrowser with LoginAuthorization {

  override def beforeAll(): Unit = {
    driver = new ChromeDriver(chromeOptions)
    chromeDriver = System.setProperty("webdriver.chrome.driver","chromedriver")
    explicitWait = new WebDriverWait(driver,30,100)
    logInFacebook(driver,getEmailId(),getPassword())
  }

  override def afterAll(): Unit = {
    driver.close()
  }



}