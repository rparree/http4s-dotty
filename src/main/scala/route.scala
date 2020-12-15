import cats._
import cats.data._
import cats.implicits._

import cats.effect.Sync
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl


object LivenessRoutes:

  def routes[F[_] : Sync]: HttpRoutes[F] =
    val dsl = new Http4sDsl[F] {}
    import dsl._
    HttpRoutes.of[F] {
      case GET -> Root / "version" =>
        for
        resp <- Ok("alive")
          yield resp
    }
