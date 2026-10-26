package com.example.petstore.ui.controllers

import cats.effect.IO
import org.http4s.*
import org.http4s.dsl.io.*
import org.http4s.headers.`Content-Type`

class SwaggerUIController() {

  val swaggerWebjarUrl = "/swagger-ui/5.20.1"

  val indexFile =
    s"""
      <!DOCTYPE html>
      <html lang="en">
        <head>
          <meta charset="UTF-8">
          <title>Swagger UI</title>
          <link rel="stylesheet" type="text/css" href="${swaggerWebjarUrl}/swagger-ui.css" />
          <link rel="stylesheet" type="text/css" href="${swaggerWebjarUrl}/index.css" />
          <link rel="icon" type="image/png" href="${swaggerWebjarUrl}/favicon-32x32.png" sizes="32x32" />
          <link rel="icon" type="image/png" href="${swaggerWebjarUrl}/favicon-16x16.png" sizes="16x16" />
        </head>
      
        <body>
          <div id="swagger-ui"></div>
          <script src="${swaggerWebjarUrl}/swagger-ui-bundle.js" charset="UTF-8"> </script>
          <script src="${swaggerWebjarUrl}/swagger-ui-standalone-preset.js" charset="UTF-8"> </script>
          <!-- <script src="${swaggerWebjarUrl}/swagger-initializer.js" charset="UTF-8"> -->
          <script>
          window.onload = function() {
            window.ui = SwaggerUIBundle({
              url: "/openapi.json",
              dom_id: '#swagger-ui',
              deepLinking: true,
              presets: [
                SwaggerUIBundle.presets.apis,
                SwaggerUIStandalonePreset
              ],
              plugins: [
                SwaggerUIBundle.plugins.DownloadUrl
              ],
              layout: "StandaloneLayout"
            });
          };
          </script>
        </body>
      </html>
    """

  def routes = HttpRoutes.of[IO] {
    case GET -> Root / "swagger" =>
      Ok(indexFile, `Content-Type`(MediaType.text.html))
    case GET -> Root =>
      TemporaryRedirect(headers.Location(Uri.unsafeFromString("/swagger")))
  }
}
