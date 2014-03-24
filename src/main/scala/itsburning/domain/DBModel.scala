package itsburning.domain

import scala.slick.jdbc.JdbcBackend.{Database, Session}

/**
 * Created by Enskamon on 16.2.2014.
 */
class DBModel(name: String, dal: DAL, db: Database) {

  import dal._

  implicit val session = db.createSession

  def createDB() = dal.create
  def dropDB() = dal.drop

  def getProducts(): List[Product] = {
    val result = allProducts
    println("Got products " + result)
    result
  }

  def getProduct(id: Long): Option[Product] = {
    println("Fetching product with id " + id)
    val result = getById(id)
    result
  }

  def addProduct(product: Product): Int = insert(product)
}
