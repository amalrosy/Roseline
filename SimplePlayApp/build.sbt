name := "SimplePlayApp"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "com.typesafe.akka" % "akka-remote_2.10" % "2.2.3"
)
     
play.Project.playJavaSettings