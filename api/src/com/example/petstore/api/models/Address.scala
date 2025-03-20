package com.example.petstore.api.models
import java.time.*
import java.util.UUID
import org.typelevel.jawn.ast.JValue
import ba.sake.tupson.*
import ba.sake.validson.Validator
case class Address(street: Option[String], city: Option[String], state: Option[String], zip: Option[String]) derives JsonRW