package com.example.petstore.main

import ba.sake.sharaf.*
import ba.sake.sharaf.undertow.UndertowSharafServer
import com.example.petstore.api.controllers.*
import com.example.petstore.ui.controllers.SwaggerUIController

@main def apiMain =
  val routes = Routes.merge(
    Seq(
      UserController().routes,
      PetController().routes,
      StoreController().routes,
      SwaggerUIController().routes
    )
  )
  UndertowSharafServer("localhost", 8080, routes).start()
  println("Server started at http://localhost:8080")
