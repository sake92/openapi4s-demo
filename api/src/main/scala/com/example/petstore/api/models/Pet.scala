package com.example.petstore.api.models
import java.time.*
import java.util.UUID
import io.circe.{Codec, Json}
import io.circe.derivation.{Configuration, ConfiguredCodec, ConfiguredEnumCodec}
case class Pet(
    id: Option[Long],
    name: String,
    category: Option[Category],
    photoUrls: Seq[String],
    tags: Option[Seq[Tag]],
    status: Option[PetStatus]
)
object Pet:
  given Configuration = Configuration.default
  given Codec[Pet] = ConfiguredCodec.derived
enum PetStatus:
  case available, pending, sold
object PetStatus:
  given Configuration = Configuration.default
  given Codec[PetStatus] = ConfiguredEnumCodec.derived
