package itsburning.service

import spray.routing.{HttpService, Route}
import itsburning.domain._

trait SprayService extends HttpService { this: DBConfig =>

  val apiRoute: Route = {
    import spray.httpx.SprayJsonSupport.sprayJsonMarshaller
    import spray.httpx.SprayJsonSupport.sprayJsonUnmarshaller
    import JsonImplicits._

    path("products") {
      get { ctx =>
        ctx.complete {
          val result: List[Product] = m.getProducts()
          result
        }
      }
    } ~
    path("product") {
      post { ctx =>
        entity(as[Product]) { product =>
          val id: Int = m.addProduct(product)
          complete(id.toString)
        }
      }
    }
  }  
}