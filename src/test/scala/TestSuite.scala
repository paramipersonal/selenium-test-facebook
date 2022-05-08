import org.scalatest.Sequential
import selenium._

class TestSuite extends Sequential (
  new LoginLogoutSpec,
  new PostSpec
)
