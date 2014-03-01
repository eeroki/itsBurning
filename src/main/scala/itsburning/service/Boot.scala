package itsburning

import akka.actor.{Props, ActorSystem}
import scala.util.Properties.{ lineSeparator => newLine }
import akka.io.IO
import spray.can.Http
import itsburning.service._

object Boot extends App {

  private def waitForExit() = {
    def waitEOF(): Unit =  Console.readLine() match {
      case "exit" => system.shutdown()
      case _ => waitEOF()
    }
    waitEOF()
  }

  // we need an ActorSystem to host our application in
  implicit val system = ActorSystem("itsBurning-actor-system")

  // Configuration
  val host = ServiceSettings(system).host
  val port = ServiceSettings(system).port
  val timeout = ServiceSettings(system).timeout

  val service = system.actorOf(Props[ServiceActor], "itsBurning-service")

  IO(Http) ! Http.Bind(service, host, port)

  Console.println(s"Server started")
  Console.println("Type 'exit' to shutdown")
  
  waitForExit()
}