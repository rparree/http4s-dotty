package util

import cats.effect.{Blocker, ContextShift, IO, Resource, Sync}
import cats._
import cats.implicits._
import cats.data._

case class WebConfig(port: Int)

case class Config(web: WebConfig)


def load[F[_]: Sync: ContextShift](configFile: String = "application.conf"): Resource[F, Config] =
  Blocker[F].flatMap { blocker =>
    Resource.liftF(Config(WebConfig(8999)).pure[F]) // TODO hardcoded for now, until pureconfig/shapeless can be added
  }