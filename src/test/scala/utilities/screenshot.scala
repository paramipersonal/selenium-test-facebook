package utilities

import org.openqa.selenium.{OutputType, TakesScreenshot, WebDriver}

import java.io.File
import utilities.common._
import org.apache.commons.io.FileUtils

import scala.util.Random



object screenshot {

  val fileName: String = Random.alphanumeric.take(5).mkString
  def takeScreenshotToVerifyPost(driver: WebDriver): Unit = {
    val sourceScreenshotFile = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
    try {
      val destinationScreenshotFile = new File(captureDirectory+"/"+fileName+".png")
      FileUtils.copyFile(sourceScreenshotFile,destinationScreenshotFile)
      println("Sreenshot stored in :" +destinationScreenshotFile.getAbsolutePath)
        } catch {
      case e:Exception => println(e+" file could not be copied in the desired location.")
    }

  }

}
