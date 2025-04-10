package com.example.petstore.api.models
import java.time.*
import java.util.UUID
import io.circe.{ Codec, Json }
import io.circe.derivation.{ Configuration, ConfiguredCodec, ConfiguredEnumCodec }
case class ApiResponse(code: Option[Int], `type`: Option[String], message: Option[String])
object ApiResponse {
  given Configuration = Configuration.default
  given Codec[ApiResponse] = ConfiguredCodec.derived
}