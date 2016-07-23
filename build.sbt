/*
Why SBT?
  Sane(ish) dependency management
  Ivy for dependency management
  Only-update-on-request model
  Full Scala language support for creating tasks
  Continuous command execution
  Launch REPL in project context


[local ~/projects]$ sbt
Project does not exist, create new project? (y/N/s) y


project – project definition files
  project/build/ yourproject .scala – the main project definition file
  project/build.properties – project, sbt and scala version definitions

src/main – your app code goes here, in a subdirectory indicating the
code’s language (e.g. src/main/scala, src/main/java)

src/main/resources – static files you want added to your jar
(e.g. logging config)

src/test – like src/main, but for tests

lib_managed – the jar files your project depends on. Populated by sbt update

target – the destination for generated stuff (e.g. generated thrift
code, class files, jars)

sbt test
sbt> test

sbt 'test-only com.twitter.sample.SampleSpec'

SBT allows you to start a Scala REPL with all your project
dependencies loaded.
>console

 */

/*
Quick Reference
Common Commands
  actions – show actions available for this project
  update – downloads dependencies
  compile – compiles source
  test – runs tests
  package – creates a publishable jar file
  publish-local – installs the built jar in your local ivy cache
  publish – pushes your jar to a remote repo (if configured)

Moar Commands
  test-failed – run any specs that failed
  test-quick – run any specs that failed and/or had dependencies updated
  clean-cache – remove all sorts of sbt cached stuff. Like clean for sbt
  clean-lib – remove everything in lib_managed

 */

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

