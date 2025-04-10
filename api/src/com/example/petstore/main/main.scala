package com.example.petstore.main

import cats.effect.*
import cats.syntax.all.*
import com.comcast.ip4s.*
import fs2.io.net.Network
import org.http4s.ember.client.EmberClientBuilder
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.implicits.*
import org.http4s.server.middleware.Logger
import com.example.petstore.api.routes.*

object Main extends IOApp.Simple:
  val run = {
    for {
      client <- EmberClientBuilder.default[IO].build
      httpApp =
        (PetRoutes().routes <+> UserRoutes().routes <+> StoreRoutes().routes).orNotFound
      finalHttpApp = Logger.httpApp(true, true)(httpApp)
      _ <-
        EmberServerBuilder
          .default[IO]
          .withHost(ipv4"0.0.0.0")
          .withPort(port"8080")
          .withHttpApp(finalHttpApp)
          .build
    } yield ()
  }.useForever
