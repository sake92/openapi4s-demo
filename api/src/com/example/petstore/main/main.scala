package com.example.petstore.main

import io.undertow.Undertow
import ba.sake.sharaf.*, routing.*
import com.example.petstore.api.controllers.*

@main def apiMain =
  val allRoutes = Seq[Routes](
    new UserController().routes,
    new PetController().routes,
    new StoreController().routes
  )
  Undertow.builder
    .addHttpListener(8080, "localhost")
    .setHandler(SharafHandler(Routes.merge(allRoutes)))
    .build
    .start()
  println("Server started at http://localhost:8080")
