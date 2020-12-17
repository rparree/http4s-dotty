import cats._
import cats.data._
import cats.implicits._
import cats.effect.IO

import org.http4s.HttpRoutes
import org.http4s.dsl.io._


object LivenessRoutes:

  def routes: HttpRoutes[IO] =
    HttpRoutes.of[IO] {
      case GET -> Root / "version" =>
        for
        resp <- Ok("alive")
          yield resp
    }
