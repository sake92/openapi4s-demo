package com.example.petstore.main

import io.undertow.Undertow
import ba.sake.sharaf.*, routing.*
import com.example.petstore.api.controllers.*

@main def apiMain =
  val allRoutes = Seq[Routes](
    new UserController().routes,
    new PetController().routes,
    new StoreController().routes
  )
  Undertow.builder
    .addHttpListener(8080, "localhost")
    .setHandler(SharafHandler(Routes.merge(allRoutes)))
    .build
    .start()
  println("Server started at http://localhost:8080")

/* http4s version */
/*
import cats.effect.{IO, IOApp, Resource}
import cats.implicits._
import org.http4s.implicits._
import com.comcast.ip4s._
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.server.middleware.Logger
import ba.sake.petstore.api.routes.*

object Main extends IOApp.Simple {
  override def run: IO[Unit] = (for {
    _ <- Resource.pure(())
    httpApp = (
      new UserRoutes().routes <+>
        new PetRoutes().routes <+>
        new StoreRoutes().routes
      ).orNotFound
    finalHttpApp = Logger.httpApp(true, true)(httpApp)
    _ <-
      EmberServerBuilder
        .default[IO]
        .withHost(ipv4"0.0.0.0")
        .withPort(port"8080")
        .withHttpApp(finalHttpApp)
        .build
  } yield ()).useForever
}
 */
