# Selenium Test Facebook

* [Prerequisites](#prerequisites)
* [Dependencies used in build.sbt](#dependencies-used-in-buildsbt)
* [Clone and run project](#clone-and-run-project)
* [Project Structure and Descriptions](#project-structure-and-descriptions)
* [Constraints](#constraints)
* [Challenges](#challenges)
* [Next Steps that could be taken](#next-steps-that-could-be-taken)

## Prerequisites
1. **IntelliJ**: IntelliJ Community Edition can be downloaded from : [IntelliJ Download Link](https://www.jetbrains.com/idea/download/#section=windows). Using, IntelliJ will help in easy installation of scala and other dependencies.
2. **Chromedriver**: Selenium Webdriver is going to need the chromedriver to launch Google Chrome browser while running selenium test.
   It can be downloaded from : [Chromedriver download link](https://chromedriver.chromium.org/downloads). Depending on the operating system being
   used, one can choose which .exe file should be downloaded.

## Dependencies used in build.sbt
```
libraryDependencies += "org.scalatest"  %% "scalatest" % "3.2.0" % "test"
libraryDependencies += "org.scalatestplus"  %% "selenium-3-141" % "3.2.0.0" % "test"
libraryDependencies += "org.seleniumhq.selenium" % "selenium-java" % "3.14.0" % "test"
```

## Clone and Run Project:
1. Clone the repository using the git command:
```
git clone https://github.com/paramipersonal/selenium-test-facebook.git
```
3. Put the downloaded chromedriver.exe inside the project directory, in this case FacebookLoginLout
4. Open the project in IntelliJ , Using open Project from existing sources.
5. If there is no existing Scala SDK, IntelliJ will pop up download instuctions. Please download scala 2.13.8
6. Let IntelliJ resolve the other required dependencies
7. Create a directory "screenshots" under project root . This will ensure that the screenshots are saved in that directory, whenever the test fails.
8. IntelliJ will give option to start to project build, click on that.
9. Click on TestSuite.scala and click run to run the test classes.


## Project Structure and Descriptions
This is a simple project that uses Selenium WebDriver and scalatest
to perform the below actions:
1. Launch Facebook
2. Log in to Facebook successfully
3. Log out from Facebook successfully
4. Tries to log in without password and fails
5. Creates a post and verifies the same
6. Takes screenshot whenever a test fails.
7. Also, takes screenshots, as per developer's needs.

### Files
There are three directories & a file under the [scala directory](https://github.com/paramipersonal/selenium-test-facebook/tree/master/src/test/scala) which is nested under test directory , which is nested under src directory:
* [File: TestSuite.scala](#testsuitescala-)
* [Directory: authorization](#file-inside-authorization-directory)
* [Directory: utilities](#files-inside-utilities-directory)
* [Directory: selenium](#files-inside-selenium-directory)


#### **TestSuite.scala** : 

Scala suite class, which runs all the test classes present inside selenium
sequentially in the order of their mention in this file.

#### File inside **authorization** directory 

**LoginAuthorization.scala** : Scala trait storing the below informations: 
1. variables containing email id and password used for facebook login
2. getter and setter methods for email id and password.

#### Files inside **utilities** directory

**common.scala** : Scala object storing common methods to be accessed the most from multiple tests.

**post.scala** : Scala object containing special methods used by PostSpec.scala

**screenshot.scala** : Scala object containing a custom method which can be used anywhere the developer needs to 
take screenshot (this is different from the withScreenshot method, which takes screenshots only when a test fails.)

#### Files inside **selenium** directory

| Class Name            | Test                                                                                                                                     |
|-----------------------|------------------------------------------------------------------------------------------------------------------------------------------|
| BaseSpec.scala        | Abstract class ensuring all the necessary initializations, launches and logs in the facebook.Ensures webdriver close after end of tests. |        
| LoginLogoutSpec.scala | Scala class containing tests to verify proper facebook login,logout,improper login                                                       |
| PostSpec.scala        | Contains test to verify that status is created and posted properly                                                                       |        


## Constraints: 

It has been observed that various facebook profile had various navigation patterns involved.
I observed a couple of facebook profiles, in the same machine, same browser and found two different UI navigation patterns.
Please find the types below :

**Type1** :
![Image1](https://github.com/paramipersonal/selenium-test-facebook/blob/dev/parami-branch-7/images/UI_test1.PNG)



**Type2** : 

![Image2](https://github.com/paramipersonal/selenium-test-facebook/blob/dev/parami-branch-7/images/UI_test2.PNG)


Here I have used **Type1** of UI for navigation steps inside selenium.
If anyone has the **Type2**, one can modify the following methods before running the tests: 
```
def goToTimeline(): Unit = {
    explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div/div[1]/div[1]/div/div[1]/span/div/div[2]"))).click()
    explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/me/']"))).click()
    explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[.='Photos']")))
  }
```

```
 def logOutOfFacebook(): Unit = {
    explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div/div[1]/div[1]/div/div[1]/span/div/div[2]"))).click()
    explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(s"//span[.='See your profile']")))
    val logout = explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(s"//span[.='Log Out']")))
    logout.click()
    explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")))
  }
```

Also, facebook does not lets anyone post repeatedly in a short span of time. Thus, had to stay
careful about getting blocked. 

## Challenges

Since most of the css selectors were created dynamically, finding locators and selecting the proper 
DOM locators in a way that the code can be re-used , was the primary challenge. 


## Next Steps that could be taken:
* More basic but similar functionalities could be tested . Some examples are : add a story, add About, add Photos.
* Facebook does not allow posting two identical posts within a short interval of time. This could be tested.
