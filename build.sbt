import ba.sake.openapi4s.OpenApi4sPlugin

ThisBuild / scalaVersion := "3.7.1"

lazy val root = project
  .in(file("."))
  .aggregate(api)
  .settings(publish / skip := true)

lazy val api = project
  .enablePlugins(OpenApi4sPlugin)
  .settings(
    libraryDependencies ++= Seq(
      "ba.sake" %% "sharaf-undertow" % "0.13.0",
      "ba.sake" %% "tupson" % "0.30.0",
      "org.webjars" % "swagger-ui" % "5.20.1"
    ),
    Compile / mainClass := Some("com.example.petstore.main.apiMain"),
    openApi4sPackage := "com.example.petstore.api",
    openApi4sFile := (Compile / resourceDirectory).value / "public" / "openapi.json",
    openApi4sValidation := "validson",
    openApi4sVersion := "0.9.0"
  )
