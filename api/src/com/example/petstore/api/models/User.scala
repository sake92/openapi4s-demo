package com.example.petstore.api.models
import java.time.*
import java.util.UUID
import org.typelevel.jawn.ast.JValue
import ba.sake.tupson.*
import ba.sake.validson.Validator
case class User(id: Option[Long], username: Option[String], firstName: Option[String], lastName: Option[String], email: Option[String], password: Option[String], phone: Option[String], userStatus: Option[Int]) derives JsonRW