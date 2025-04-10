package com.example.petstore.api.models
import java.time.*
import java.util.UUID
import io.circe.{ Codec, Json }
import io.circe.derivation.{ Configuration, ConfiguredCodec, ConfiguredEnumCodec }
case class Order(id: Option[Long], petId: Option[Long], quantity: Option[Int], shipDate: Option[Instant], status: Option[OrderStatus], complete: Option[Boolean])
object Order {
  given Configuration = Configuration.default
  given Codec[Order] = ConfiguredCodec.derived
}
enum OrderStatus { case placed, approved, delivered }
object OrderStatus {
  given Configuration = Configuration.default
  given Codec[OrderStatus] = ConfiguredEnumCodec.derived
}