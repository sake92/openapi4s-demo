package com.example.petstore.api.routes
import java.time.*
import java.util.UUID
import cats.effect.IO
import org.http4s.{HttpRoutes, QueryParamDecoder}
import org.http4s.dsl.io.*
import org.http4s.circe.CirceEntityCodec.*
import com.example.petstore.api.models.*
class PetRoutes:
  private object StatusQueryParamMatcher
      extends OptionalQueryParamDecoderMatcher[String]("status")
  private object TagsQueryParamMatcher
      extends OptionalMultiQueryParamDecoderMatcher[String]("tags")
  private object NameQueryParamMatcher
      extends OptionalQueryParamDecoderMatcher[String]("name")
  private object StatusQueryParamMatcher2
      extends OptionalQueryParamDecoderMatcher[String]("status")
  private object AdditionalmetadataQueryParamMatcher
      extends OptionalQueryParamDecoderMatcher[String]("additionalMetadata")
  def routes = HttpRoutes.of[IO] {
    case req @ PUT -> Root / "pet" =>
      for reqBody <- req.as[Pet]; resp <- NotImplemented("TODO: return Pet")
      yield resp
    case req @ POST -> Root / "pet" =>
      for reqBody <- req.as[Pet]; resp <- NotImplemented("TODO: return Pet")
      yield resp
    case req @ GET -> Root / "pet" / "findByStatus" :? StatusQueryParamMatcher(
          status
        ) =>
      for resp <- NotImplemented("TODO: return Seq[Pet]") yield resp
    case req @ GET -> Root / "pet" / "findByTags" :? TagsQueryParamMatcher(
          cats.data.Validated.Valid(tags)
        ) =>
      for resp <- NotImplemented("TODO: return Seq[Pet]") yield resp
    case req @ GET -> Root / "pet" / petId =>
      for resp <- NotImplemented("TODO: return Pet") yield resp
    case req @ POST -> Root / "pet" / petId :? NameQueryParamMatcher(
          name
        ) +& StatusQueryParamMatcher2(status) =>
      for resp <- NotImplemented() yield resp
    case req @ DELETE -> Root / "pet" / petId =>
      for resp <- NotImplemented() yield resp
    case req @ POST -> Root / "pet" / petId / "uploadImage" :? AdditionalmetadataQueryParamMatcher(
          additionalMetadata
        ) =>
      for resp <- NotImplemented("TODO: return ApiResponse") yield resp
  }
