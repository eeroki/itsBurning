package itsburning.service

import spray.routing.{HttpService, Route}
import itsburning.domain._
import spray.http.StatusCodes._

trait SprayService extends HttpService { this: DBConfig =>

  val apiRoute: Route = {
    import spray.httpx.SprayJsonSupport.sprayJsonMarshaller
    import spray.httpx.SprayJsonSupport.sprayJsonUnmarshaller
    import JsonImplicits._

    path("products") {
      get {
        complete {
          val result: List[Product] = m.getProducts()
          result
        }
      }
    } ~
    path("products" / IntNumber) { id =>
      get {
        complete {
          m.getProduct(id.toLong) match {
            case Some(product) => product
            case None => NotFound
          }
        }
      }
    }
  }

}