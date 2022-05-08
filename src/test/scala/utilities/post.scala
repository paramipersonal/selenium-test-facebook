package utilities
import common._
import org.openqa.selenium.{By, WebElement}
import org.openqa.selenium.support.ui.ExpectedConditions

object post {

  def createPost(post: String): Unit = {
   locateCreatePostBox()
   typePostText(post)
   clickPostButton()
   Thread.sleep(3000)
  }

  def locateCreatePostBox(): Unit = {
    val createPostBox = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(s"//div[contains(@aria-label,'Create a post')]//div[contains(@role,'button')]")))
    createPostBox.click()
  }

  def typePostText(post: String): Unit = {
    val textAreaForPost = locateTextAreaForPost()
    textAreaForPost.sendKeys(post)
  }

  def locateTextAreaForPost(): WebElement = {
    var textAreaForPost = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(s"//form[contains(@method,'POST')]//div[contains(@role,'presentation')]")))
    textAreaForPost = textAreaForPost.findElement(By.cssSelector("div[aria-describedby*='placeholder-']"))
    textAreaForPost.click()
    textAreaForPost
  }


  def clickPostButton(): Unit = {
    val postButton = explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[aria-label='Post']")))
    postButton.click()
  }

  def verifyPostedStatus(status: String): Unit = {
    val findPost = driver.findElement(By.xpath(s"//*[text()='$status']"))
    assert(findPost.getText.equals(status))
  }
}
