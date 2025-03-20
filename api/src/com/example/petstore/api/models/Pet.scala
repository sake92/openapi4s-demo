package com.example.petstore.api.models
import java.time.*
import java.util.UUID
import org.typelevel.jawn.ast.JValue
import ba.sake.tupson.*
import ba.sake.validson.Validator
case class Pet(id: Option[Long], name: String, category: Option[Category], photoUrls: Seq[String], tags: Option[Seq[Tag]], status: Option[PetStatus]) derives JsonRW
enum PetStatus derives JsonRW { case available, pending, sold }