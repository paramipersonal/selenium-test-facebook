package selenium

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
        //An alternative way is to take screenshot of the status posted and store it.
        //takeScreenshotToVerifyPost(driver)
    }
  }

}
