package com.example.petstore.api.routes
import java.time.*
import java.util.UUID
import cats.effect.IO
import org.http4s.{HttpRoutes, QueryParamDecoder}
import org.http4s.dsl.io.*
import org.http4s.circe.CirceEntityCodec.*
import com.example.petstore.api.models.*
class UserRoutes:
  private object UsernameQueryParamMatcher
      extends OptionalQueryParamDecoderMatcher[String]("username")
  private object PasswordQueryParamMatcher
      extends OptionalQueryParamDecoderMatcher[String]("password")
  def routes = HttpRoutes.of[IO] {
    case req @ POST -> Root / "user" =>
      for reqBody <- req.as[User]; resp <- NotImplemented("TODO: return User")
      yield resp
    case req @ POST -> Root / "user" / "createWithList" =>
      for
        reqBody <- req.as[Seq[User]];
        resp <- NotImplemented("TODO: return User")
      yield resp
    case req @ GET -> Root / "user" / "login" :? UsernameQueryParamMatcher(
          username
        ) +& PasswordQueryParamMatcher(password) =>
      for resp <- NotImplemented("TODO: return String") yield resp
    case req @ GET -> Root / "user" / "logout" =>
      for resp <- NotImplemented() yield resp
    case req @ GET -> Root / "user" / username =>
      for resp <- NotImplemented("TODO: return User") yield resp
    case req @ PUT -> Root / "user" / username =>
      for reqBody <- req.as[User]; resp <- NotImplemented() yield resp
    case req @ DELETE -> Root / "user" / username =>
      for resp <- NotImplemented() yield resp
  }
