package selenium

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import utilities.common._
import utilities.post._
import utilities.screenshot._

class PostSpec extends BaseSpec {

  markup("This class will contains tests related to publishing posts in facebook.")

  private val STATUS = "This is the new status to post."

  "Clicking on Post Button after creating a post in facebook" should "create a post in facebook" in {
    withScreenshot{
        clickFacebookHome()
        createPost(STATUS)
        goToTimeline()
        scrollDown("window.scrollBy(0,500)")
        verifyPostedStatus(STATUS)
        //You can also store screenshot of the posted status. Uncomment the below method to do so.
        //takeScreenshotToVerifyPost(driver)
    }
  }



}
