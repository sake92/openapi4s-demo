package com.example.petstore.api.models
import java.time.*
import java.util.UUID
import io.circe.{ Codec, Json }
import io.circe.derivation.{ Configuration, ConfiguredCodec, ConfiguredEnumCodec }
case class User(id: Option[Long], username: Option[String], firstName: Option[String], lastName: Option[String], email: Option[String], password: Option[String], phone: Option[String], userStatus: Option[Int])
object User {
  given Configuration = Configuration.default
  given Codec[User] = ConfiguredCodec.derived
}