package com.example.petstore.api.models

import java.time.*
import java.util.UUID
import io.circe.{Codec, Json}
import io.circe.derivation.{Configuration, ConfiguredCodec, ConfiguredEnumCodec}

case class Address(
  street: Option[String],
  city: Option[String],
  state: Option[String],
  zip: Option[String], street2: Option[String]
)

object Address {
  given Configuration = Configuration.default
  given Codec[Address] = ConfiguredCodec.derived
  val x = ""
}

