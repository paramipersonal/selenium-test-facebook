package selenium

import authorization._
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.selenium.WebBrowser
import utilities.common._
import org.openqa.selenium.support.ui.WebDriverWait

import java.io.File

abstract class BaseSpec extends AnyFlatSpec with Matchers with BeforeAndAfterAll with WebBrowser with LoginAuthorization {


  override def beforeAll(): Unit = {
    println("Entered before all.")
    driver = new ChromeDriver(chromeOptions)
    println("Driver:" +driver)
    System.setProperty("webdriver.chrome.driver","chromedriver.exe")
    explicitWait = new WebDriverWait(driver,30,100)
    setCaptureDir(captureDirectory)
    logInFacebook(driver,getEmailId(),getPassword())
  }

  override def afterAll(): Unit = {
    driver.close()
  }

  override def withScreenshot[T](fun: => T)(implicit driver: WebDriver): T = {
    try {
      fun
    }
    catch {
      case e: org.scalatest.exceptions.ModifiableMessage[_] =>
        throw e.modifyMessage{ (currentMessage: Option[String]) =>
          val captureFile: File = capture.apply()
          currentMessage match {
            case Some(currentMsg) =>
              Some(currentMsg + "; screenshot captured in " + captureFile.getAbsolutePath)
            case None =>
              Some("screenshot captured in " + captureFile.getAbsolutePath)
          }
        }
      case e: Any =>
        val captureFile: File = capture.apply()
        println("screenshot captured in " +captureFile.getAbsolutePath)
        throw e
    }
  }




}