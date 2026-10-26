package com.example.petstore

import cats.effect.{IO, IOApp}
import com.comcast.ip4s.*
import java.net.URI
import java.net.http.{HttpClient, HttpRequest, HttpResponse}
import java.time.Duration
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.server.middleware.ErrorHandling
import com.example.petstore.main.Main

object HttpSmokeTest extends IOApp.Simple {
  private val client = HttpClient.newHttpClient()

  def run: IO[Unit] =
    EmberServerBuilder
      .default[IO]
      .withHost(ipv4"127.0.0.1")
      .withPort(port"0")
      .withHttpApp(ErrorHandling.httpRoutes(Main.routes).orNotFound)
      .build
      .use { server =>
        val base = s"http://127.0.0.1:${server.address.getPort}"
        def check(path: String, status: Int, body: Option[String] = None)(
            verify: HttpResponse[String] => Unit
        ): IO[Unit] =
          IO.blocking {
            val builder = HttpRequest
              .newBuilder(URI.create(base + path))
              .timeout(Duration.ofSeconds(10))
            val request = body
              .fold(builder.GET())(json =>
                builder
                  .header("Content-Type", "application/json")
                  .POST(HttpRequest.BodyPublishers.ofString(json))
              )
              .build()
            val response =
              client.send(request, HttpResponse.BodyHandlers.ofString())
            assert(
              response.statusCode() == status,
              s"$path: expected $status, got ${response.statusCode()}: ${response.body()}"
            )
            verify(response)
            println(s"PASS $path ($status)")
          }
        for
          _ <- check("/", 307)(r =>
            assert(r.headers().firstValue("location").orElse("") == "/swagger")
          )
          _ <- check("/swagger", 200)(r =>
            assert(
              r.headers()
                .firstValue("content-type")
                .orElse("")
                .startsWith("text/html")
            )
          )
          _ <- check("/openapi.json", 200)(r =>
            assert(
              io.circe.jawn
                .parse(r.body())
                .toOption
                .exists(_.hcursor.downField("openapi").as[String].isRight)
            )
          )
          _ <- check("/swagger-ui/5.20.1/swagger-ui-bundle.js", 200)(r =>
            assert(r.body().nonEmpty)
          )
          _ <- check("/pet/findByStatus?status=available", 501)(_ => ())
          _ <- check("/pet/findByTags?tags=cat&tags=dog", 501)(_ => ())
          _ <- check(
            "/pet",
            501,
            Some("""{"name":"Rex","photoUrls":[],"status":"available"}""")
          )(_ => ())
          _ <- check("/pet", 400, Some("{"))(_ => ())
          _ <- check("/pet", 422, Some("""{"photoUrls":[]}"""))(_ => ())
          _ <- check("/missing", 404)(_ => ())
        yield ()
      }
}
