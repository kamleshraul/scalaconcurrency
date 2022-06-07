scalaVersion := "2.13.7"
name := "scalaconcurrency"

val AkkaVersion = "2.6.19"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion%Test,
  "org.scalatest" %% "scalatest" % "3.2.12" % "test"
)

    libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.11"
    libraryDependencies += "org.scala-lang.modules" %% "scala-parallel-collections" % "0.2.0"
    libraryDependencies += "commons-io" % "commons-io" % "2.11.0"

    