package com.example.petstore.api.models
import java.time.*
import java.util.UUID
import io.circe.{ Codec, Json }
import io.circe.derivation.{ Configuration, ConfiguredCodec, ConfiguredEnumCodec }
case class Customer(id: Option[Long], username: Option[String], address: Option[Seq[Address]])
object Customer {
  given Configuration = Configuration.default
  given Codec[Customer] = ConfiguredCodec.derived
}