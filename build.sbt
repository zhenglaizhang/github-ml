name := """github-ml"""

version := "1.0"

scalaVersion := "2.11.8"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies += "com.jsuereth" % "scala-arm_2.11" % "1.4"

// http://etorreborre.github.io/specs2/
libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.8.4" % "test")
scalacOptions in Test ++= Seq("-Yrangepos")

// http://www.scalacheck.org
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.13.2" % "test"

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

