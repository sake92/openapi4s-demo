package com.example.petstore.api.routes

import java.time.*
import java.util.UUID
import cats.effect.IO
import cats.syntax.all.*
import org.http4s.HttpRoutes
import org.http4s.dsl.io.*
import org.http4s.circe.CirceEntityCodec.*
import com.example.petstore.api.models.*
import io.github.iltotore.iron.*

class PetRoutes {
  def routes = HttpRoutes.of[IO] {
    case req @ PUT -> Root / "pet" =>
      for {
        reqBody <- req.as[Pet].handleErrorWith(IO.raiseError)
        res <- Ok(reqBody)
      } yield res
    case req @ POST -> Root / "pet" =>
      for {
        res <- req
          .as[Pet]
          .flatMap { reqBody =>
            NotImplemented("TODO: return Pet")
          }
          .handleErrorWith {
            case org.http4s.InvalidMessageBodyFailure(err, ex) =>
              BadRequest(err)
          }
      } yield res
    case req @ GET -> Root / "pet" / "findByStatus" =>
      for {
        resp <- Ok(
          Seq(
            Pet(
              id = 1L.some,
              category = Category(id = 1L.some, name = "Dog".some).some,
              name = "Dog",
              photoUrls = Seq("http://example.com/dog.jpg"),
              tags = Seq(Tag(id = 1L.some, name = "Dog".some)).some,
              status = PetStatus.available.some
            )
          )
        )
      } yield resp
    case req @ GET -> Root / "pet" / "findByTags" =>
      for (resp <- NotImplemented("TODO: return Seq[Pet]")) yield resp
    case req @ GET -> Root / "pet" / petId =>
      for (resp <- NotImplemented("TODO: return Pet")) yield resp
    case req @ POST -> Root / "pet" / petId =>
      for (resp <- NotImplemented()) yield resp
    case req @ DELETE -> Root / "pet" / petId =>
      for (resp <- NotImplemented()) yield resp
    case req @ POST -> Root / "pet" / petId / "uploadImage" =>
      for (resp <- NotImplemented("TODO: return ApiResponse")) yield resp
  }

}
