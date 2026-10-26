package com.example.petstore.main

import cats.effect.{IO, IOApp}
import cats.syntax.all.*
import com.comcast.ip4s.*
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.server.middleware.ErrorHandling
import org.http4s.server.staticcontent.*
import com.example.petstore.api.routes.*
import com.example.petstore.ui.controllers.SwaggerUIController

object Main extends IOApp.Simple {
  val routes =
    UserRoutes().routes <+> PetRoutes().routes <+> StoreRoutes().routes <+>
      SwaggerUIController().routes <+>
      resourceServiceBuilder[IO]("/public").toRoutes <+>
      webjarServiceBuilder[IO].toRoutes

  def run: IO[Unit] =
    EmberServerBuilder
      .default[IO]
      .withHost(host"localhost")
      .withPort(port"8080")
      .withHttpApp(ErrorHandling.httpRoutes(routes).orNotFound)
      .build
      .use(_ =>
        IO.println("Server started at http://localhost:8080") *> IO.never
      )
}
