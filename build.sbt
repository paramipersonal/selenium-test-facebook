name := "selenium-test-facebook"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.13.8"

libraryDependencies += "org.scalatest"  %% "scalatest" % "3.2.0" % "test"
libraryDependencies += "org.scalatestplus"  %% "selenium-3-141" % "3.2.0.0" % "test"
libraryDependencies += "org.seleniumhq.selenium" % "selenium-java" % "3.14.0" % "test"

