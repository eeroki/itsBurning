package itsburning.service

import akka.actor.Actor
import spray.routing.{Route}
import itsburning.domain.{DBConfig, Product, TestDB}
import spray.json.DefaultJsonProtocol

class ServiceActor extends Actor with SprayService with TestDB {
  def actorRefFactory = context
  def receive: Receive = runRoute(staticRoute ~ apiRoute)

  def staticRoute: Route = path("")(getFromResource("webapp/index.html")) ~ getFromResourceDirectory("webapp")
}

object JsonImplicits extends DefaultJsonProtocol {
  implicit val impProduct = jsonFormat4(Product)
}