lazy val buildSettings = Seq(
  organization := "com.dwolla",
  maintainer := s"dev+${name.value}@dwolla.com",
  homepage := Some(url("https://github.com/Dwolla/codecommit-human-notifications")),
  licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
  startYear := Option(2020),
  addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.0" cross CrossVersion.full),
  addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1"),
  resolvers ++= Seq(
    Resolver.bintrayRepo("dwolla", "maven"),
    Resolver.sonatypeRepo("releases"),
  ),
  mappings in (Compile, packageDoc) := Seq(),
  publishArtifact in (Compile, packageDoc) := false,
  topLevelDirectory := None,
  packageName in Universal := name.value,
)

lazy val `codestar-human-notifications` = (project in file("."))
  .settings(buildSettings: _*)
  .settings(
    description := "Listen to CodeStar event notifications, and forward messages in a human-readable way",
    libraryDependencies ++= {
      val fs2AwsVersion = "2.0.0-M9"
      Seq(
        "software.amazon.awssdk" % "codecommit" % "2.7.18",
        "org.typelevel" %% "cats-core" % "2.1.1",
        "org.typelevel" %% "cats-effect" % "2.1.2",
        "io.circe" %% "circe-optics" % "0.13.0",
        "com.dwolla" %% "fs2-aws-java-sdk2" % fs2AwsVersion,
        "com.dwolla" %% "fs2-aws-lambda-io-app" % fs2AwsVersion,
        "com.dwolla" %% "testutils-scalatest-fs2" % "2.0.0-M4" % Test,
        "com.ironcorelabs" %% "cats-scalatest" % "3.0.5" % Test,
      )
    },
  )
  .enablePlugins(UniversalPlugin, JavaAppPackaging)
