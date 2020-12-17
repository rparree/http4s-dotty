import cats.effect.{ExitCode, IO, IOApp}
import org.http4s.server.blaze.BlazeServerBuilder
import util._
import cats._
import cats.data._
import cats.implicits._
import org.http4s.implicits.http4sKleisliResponseSyntaxOptionT

import scala.concurrent.ExecutionContext.global

object Main extends IOApp:
  def run(args: List[String]): IO[ExitCode] =
    load[IO]().use((c: Config) =>
      for 
        e <- BlazeServerBuilder[IO](global)
          .withHttpApp(LivenessRoutes.routes.orNotFound)
          .bindHttp(c.web.port, "0.0.0.0").serve.compile.lastOrError
      yield e)





