package itsburning.domain

import scala.slick.driver.H2Driver
import scala.slick.jdbc.JdbcBackend.{Database, Session}


trait DBConfig {
  def m: DBModel
}

trait TestDB extends DBConfig {
  val m = new DBModel("H2", new DAL(H2Driver), Database.forURL("jdbc:h2:mem:testdb", driver = "org.h2.Driver"))
  m.createDB
  m.addProduct(Product("Mild chili popper", 1, "It's pretty mild"))
  m.addProduct(Product("Killer Nage Surprise", 5, "It will burn you to submission"))
}
