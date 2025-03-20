package com.example.petstore.api.models
import java.time.*
import java.util.UUID
import org.typelevel.jawn.ast.JValue
import ba.sake.tupson.*
import ba.sake.validson.Validator
case class Order(id: Option[Long], petId: Option[Long], quantity: Option[Int], shipDate: Option[Instant], status: Option[OrderStatus], complete: Option[Boolean]) derives JsonRW
enum OrderStatus derives JsonRW { case placed, approved, delivered }