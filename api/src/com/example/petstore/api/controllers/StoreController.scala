package com.example.petstore.api.controllers

import java.time.*
import java.util.UUID
import io.undertow.util.StatusCodes
import ba.sake.querson.QueryStringRW
import ba.sake.validson.Validator
import ba.sake.sharaf.*, routing.*
import com.example.petstore.api.models.*

class StoreController {
  def routes = Routes {
    case GET -> Path("store", "inventory") =>
      Response.withStatus(StatusCodes.NOT_IMPLEMENTED)
    case POST -> Path("store", "order") =>
      val reqBody = Request.current.bodyJsonValidated[Order]
      Response
        .withStatus(StatusCodes.NOT_IMPLEMENTED)
        .withBody("TODO: return Order")
    case GET -> Path("store", "order", param[Long](orderId)) =>
      Response
        .withStatus(StatusCodes.NOT_IMPLEMENTED)
        .withBody("TODO: return Order")
    case DELETE -> Path("store", "order", param[Long](orderId)) =>
      Response.withStatus(StatusCodes.NOT_IMPLEMENTED)
  }

}
