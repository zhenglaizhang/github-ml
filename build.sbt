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
// TODO update commands to align with latest version
Quick Reference

  clean            Deletes files produced by the build, such as generated sources, compiled classes, and task caches.
  compile          Compiles sources.
  console          Starts the Scala interpreter with the project classes on the classpath.
  consoleProject   Starts the Scala interpreter with the sbt and the build definition on the classpath and useful imports.
  consoleQuick     Starts the Scala interpreter with the project dependencies on the classpath.
  copyResources    Copies resources to the output directory.
  doc              Generates API documentation.
  package          Produces the main artifact, such as a binary jar.  This is typically an alias for the task that actually does the packaging.
  packageBin       Produces a main artifact, such as a binary jar.
  packageDoc       Produces a documentation artifact, such as a jar containing API documentation.
  packageSrc       Produces a source artifact, such as a jar containing sources and resources.
  publish          Publishes artifacts to a repository.
  publishLocal     Publishes artifacts to the local Ivy repository.
  publishM2        Publishes artifacts to the local Maven repository.
  run              Runs a main class, passing along arguments provided on the command line.
  runMain          Runs the main class selected by the first argument, passing the remaining arguments to the main method.
  test             Executes all tests.
  testOnly         Executes the tests provided as arguments or all tests if no arguments are provided.
  testQuick        Executes the tests that either failed before, were not run or whose transitive dependencies changed, among those provided as arguments.
  update           Resolves and optionally retrieves dependencies, producing a report.


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

