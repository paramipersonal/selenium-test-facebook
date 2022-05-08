# Selenium Test Facebook

This README contains the below sections:
* [Prerequisites](#prerequisites)
* [Dependencies used in build.sbt](#dependencies-used-in-buildsbt)
* [Clone and run project](#clone-and-run-project)
* [List of tests done](#list-of-tests-done)

# Project Structure and Descriptions
This is a simple project that uses Selenium WebDriver and scalatest
to perform the below actions:
1. Launch Facebook
2. Log in to Facebook successfully
3. Log out from Facebook successfully
4. Tries to log in without password and fails
5. Creates a post and verifies the same
6. Takes screenshot whenever a test fails.
7. Also, takes screenshots, as per developer's needs.

## Files
There are three directories & a file under the source (src) directory:
* Directory: authorization
* Directory: selenium
* Directory: utilities
* File: TestSuite.scala 

#### **TestSuite.scala** : 

Scala suite class, which runs all the test classes present inside selenium
sequentially in the order of their mention in this file.

### File inside **authorization** directory 

**LoginAuthorization.scala** : Scala trait storing the below informations: 
1. variables containing email id and password used for facebook login
2. getter and setter methods for email id and password.

### Files inside **utilities** directory

**common.scala** : Scala object storing common methods to be accessed the most from multiple tests.

**post.scala** : Scala object containing special methods used by PostSpec.scala

**screenshot.scala** : Scala object containing a custom method which can be used anywhere the developer needs to 
take screenshot (this is different from the withScreenshot method, which takes screenshots only when a test fails.)

### Files inside **selenium** directory

| Class Name            | Test                                                                                                                                     |
|-----------------------|------------------------------------------------------------------------------------------------------------------------------------------|
| BaseSpec.scala        | Abstract class ensuring all the necessary initializations, launches and logs in the facebook.Ensures webdriver close after end of tests. |        
| LoginLogoutSpec.scala | Scala class containing tests to verify proper facebook login,logout,improper login                                                       |
| PostSpec.scala        | Contains test to verify that status is created and posted properly                                                                       |        


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
9. Go to the terminal and inside the project directory, use ```sbt test``` to run the tests.

## Files


## List of Tests done

Below is the list of selenium test present in this project





