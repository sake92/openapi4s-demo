package com.example.petstore.api.models
import java.time.*
import java.util.UUID
import org.typelevel.jawn.ast.JValue
import ba.sake.tupson.*
import ba.sake.validson.Validator
case class Customer(id: Option[Long], username: Option[String], address: Option[Seq[Address]]) derives JsonRW