package com.example.petstore.ui.controllers

import io.undertow.util.Headers
import ba.sake.sharaf.{*, given}

class SwaggerUIController() {

  val baseUrl = "http://localhost:8080"
  val swaggerWebjarUrl = "/swagger-ui/5.20.1"

  val indexFile =
    html"""
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
              url: "${baseUrl}/openapi.json",
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

  def routes = Routes {
    case GET -> Path("swagger") =>
      Response.withBody(indexFile)
    case GET -> Path() =>
      Response.redirect("/swagger")
  }

}
