val scala3Version = "3.0.0-M2"
val Http4sVersion = "0.21.13"
//val PureConfigVersion = "0.14.0"
val LogbackVersion = "1.2.3"

lazy val root = project
  .in(file("."))
  .settings(
    name := "springest-exporter",
    version := "0.1.0",

    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      //        "org.typelevel" %% "cats-core" % "2.3.0",
      ("org.http4s" %% "http4s-blaze-server" % Http4sVersion).withDottyCompat(scalaVersion.value),

      ("org.http4s" %% "http4s-dsl" % Http4sVersion).withDottyCompat(scalaVersion.value),
      //("org.http4s" %% "http4s-circe" % Http4sVersion).withDottyCompat(scalaVersion.value),
      //("ch.qos.logback" % "logback-classic" % LogbackVersion).withDottyCompat(scalaVersion.value),
      /* ("com.github.pureconfig" %% "pureconfig" % PureConfigVersion).withDottyCompat(scalaVersion.value),
         ("com.github.pureconfig" %% "pureconfig-cats-effect" % PureConfigVersion).withDottyCompat(scalaVersion.value),*/

      //("io.chrisdavenport" %% "log4cats-slf4j" % "1.1.1").withDottyCompat(scalaVersion.value),
    )
  )
