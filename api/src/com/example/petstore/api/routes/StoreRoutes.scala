package com.example.petstore.api.routes
import java.time.*
import java.util.UUID
import cats.effect.IO
import org.http4s.HttpRoutes
import org.http4s.dsl.io.*
import org.http4s.circe.CirceEntityCodec.*
import com.example.petstore.api.models.*
class StoreRoutes {
  def routes = HttpRoutes.of[IO] {
    case req @ GET -> Root / "store" / "inventory" =>
      for (resp <- NotImplemented()) yield resp
    case req @ POST -> Root / "store" / "order" =>
      for (reqBody <- req.as[Order]; resp <- NotImplemented("TODO: return Order")) yield resp
    case req @ GET -> Root / "store" / "order" / orderId =>
      for (resp <- NotImplemented("TODO: return Order")) yield resp
    case req @ DELETE -> Root / "store" / "order" / orderId =>
      for (resp <- NotImplemented()) yield resp
  }
}