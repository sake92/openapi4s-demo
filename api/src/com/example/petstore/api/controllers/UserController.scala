package com.example.petstore.api.controllers

import java.time.*
import java.util.UUID
import io.undertow.util.StatusCodes
import ba.sake.querson.QueryStringRW
import ba.sake.validson.Validator
import ba.sake.sharaf.*, routing.*
import com.example.petstore.api.models.*

class UserController {
  def routes = Routes {
    case POST() -> Path("user") =>
      val reqBody = Request.current.bodyJsonValidated[User]
      Response
        .withStatus(StatusCodes.NOT_IMPLEMENTED)
        .withBody("TODO: return User")
    case POST() -> Path("user", "createWithList") =>
      val reqBody = Request.current.bodyJsonValidated[Seq[User]]
      Response
        .withStatus(StatusCodes.NOT_IMPLEMENTED)
        .withBody("TODO: return User")
    case GET() -> Path("user", "login") =>
      case class QP(
        username: Option[String],
        password: Option[String]
      ) derives QueryStringRW
      val qp = Request.current.queryParamsValidated[QP]
      Response
        .withStatus(StatusCodes.NOT_IMPLEMENTED)
        .withBody("TODO: return String")
    case GET() -> Path("user", "logout") =>
      Response.withStatus(StatusCodes.NOT_IMPLEMENTED)
    case GET() -> Path("user", username) =>
      Response
        .withStatus(StatusCodes.NOT_IMPLEMENTED)
        .withBody("TODO: return User")
    case PUT() -> Path("user", username) =>
      val reqBody = Request.current.bodyJsonValidated[User]
      Response.withStatus(StatusCodes.NOT_IMPLEMENTED)
    case DELETE() -> Path("user", username) =>
      Response.withStatus(StatusCodes.NOT_IMPLEMENTED)
  }

}
