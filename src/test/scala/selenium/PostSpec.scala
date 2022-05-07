package selenium

import utilities.common._
import utilities.post._

class PostSpec extends BaseSpec {

  markup("This class will contains tests related to publishing posts in facebook.")

  "Clicking on Post Button after creating a post in facebook" should "create a post in facebook" in {
    withScreenshot{
        clickFacebookHome()
        createPost()
    }
  }

}
