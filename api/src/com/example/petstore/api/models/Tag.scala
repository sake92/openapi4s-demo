package com.example.petstore.api.models
import java.time.*
import java.util.UUID
import io.circe.{ Codec, Json }
import io.circe.derivation.{ Configuration, ConfiguredCodec, ConfiguredEnumCodec }
case class Tag(id: Option[Long], name: Option[String])
object Tag {
  given Configuration = Configuration.default
  given Codec[Tag] = ConfiguredCodec.derived
}