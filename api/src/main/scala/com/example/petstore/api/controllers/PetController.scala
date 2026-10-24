package com.example.petstore.api.controllers

import java.time.*
import java.util.UUID
import sttp.model.StatusCode
import ba.sake.querson.QueryStringRW
import ba.sake.validson.Validator
import ba.sake.sharaf.*, routing.*
import com.example.petstore.api.models.*

class PetController {
  def routes = Routes {
    case PUT -> Path("pet") =>
      val reqBody = Request.current.bodyJsonValidated[Pet]
      Response
        .withStatus(StatusCode.NotImplemented)
        .withBody("TODO: return Pet")
    case POST -> Path("pet") =>
      val reqBody = Request.current.bodyJsonValidated[Pet]
      Response
        .withStatus(StatusCode.NotImplemented)
        .withBody("TODO: return Pet")
    case GET -> Path("pet", "findByStatus") =>
      enum QpStatus derives QueryStringRW { case available, pending, sold }
      case class QP(
        status: Option[QpStatus]
      ) derives QueryStringRW
      val qp = Request.current.queryParamsValidated[QP]
      Response
        .withStatus(StatusCode.NotImplemented)
        .withBody("TODO: return Seq[Pet]")
    case GET -> Path("pet", "findByTags") =>
      case class QP(
        tags: Option[Seq[String]]
      ) derives QueryStringRW
      val qp = Request.current.queryParamsValidated[QP]
      Response
        .withStatus(StatusCode.NotImplemented)
        .withBody("TODO: return Seq[Pet]")
    case GET -> Path("pet", param[Long](petId)) =>
      Response
        .withStatus(StatusCode.NotImplemented)
        .withBody("TODO: return Pet")
    case POST -> Path("pet", param[Long](petId)) =>
      case class QP(
        name: Option[String],
        status: Option[String]
      ) derives QueryStringRW
      val qp = Request.current.queryParamsValidated[QP]
      Response.withStatus(StatusCode.NotImplemented)
    case DELETE -> Path("pet", param[Long](petId)) =>
      Response.withStatus(StatusCode.NotImplemented)
    case POST -> Path("pet", param[Long](petId), "uploadImage") =>
      case class QP(
        additionalMetadata: Option[String]
      ) derives QueryStringRW
      val qp = Request.current.queryParamsValidated[QP]
      Response
        .withStatus(StatusCode.NotImplemented)
        .withBody("TODO: return ApiResponse")
  }

}
