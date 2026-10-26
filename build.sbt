import ba.sake.openapi4s.OpenApi4sPlugin

scalaVersion := "3.9.0"

lazy val root = project
  .in(file("."))
  .aggregate(api)
  .settings(publish / skip := true)

lazy val api = project
  .enablePlugins(OpenApi4sPlugin)
  .settings(
    libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-ember-server" % "0.23.38",
      "org.http4s" %% "http4s-dsl" % "0.23.38",
      "org.http4s" %% "http4s-circe" % "0.23.38",
      "io.circe" %% "circe-generic" % "0.14.15",
      "org.webjars" % "swagger-ui" % "5.20.1"
    ),
    Compile / mainClass := Some("com.example.petstore.main.Main"),
    openApi4sPackage := "com.example.petstore.api",
    openApi4sFile := (Compile / resourceDirectory).value / "public" / "openapi.json",
    openApi4sModels := "circe",
    openApi4sFramework := Some("http4s"),
    openApi4sValidation := "none",
    openApi4sVersion := "0.10.0"
  )
