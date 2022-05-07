package utilities
import common._
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions

object post {

  def createPost(): Unit = {
   locateCreatePostBox()
   clickTextAreaForPost()
   clickPostButton()
  }

  def locateCreatePostBox(): Unit = {
    val createPostBox = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(s"//div[contains(@aria-label,'Create a post')]//div[contains(@role,'button')]")))
    createPostBox.click()
  }

  def clickTextAreaForPost(): Unit = {
    var textAreaForPost = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(s"//form[contains(@method,'POST')]//div[contains(@role,'presentation')]")))
    textAreaForPost = textAreaForPost.findElement(By.cssSelector("div[aria-describedby*='placeholder-']"))
    textAreaForPost.click()
    textAreaForPost.sendKeys("Hello World")
  }

  def clickPostButton(): Unit = {
    val postButton = explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[aria-label='Post']")))
    postButton.click()
  }
}
