lazy val root = (project in file("."))
  .settings(
    name := "Chess piece moves",
    version := "0.1",
    scalaVersion := "2.12.8",
    unmanagedResourceDirectories in Compile += { baseDirectory.value / "src/main/resources" },
    
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % "10.1.8",
      "com.typesafe.akka" %% "akka-stream" % "2.5.19",
      "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.8",
      "org.slf4j" % "slf4j-nop" % "1.7.10",
      "org.scalatest" %% "scalatest" % "3.0.5" % Test,
      "org.scalamock" %% "scalamock" % "4.1.0" % Test,
    )
  )
