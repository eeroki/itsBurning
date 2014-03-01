package itsburning.domain

case class Product(name: String,
                   burn: Int,
                   description: String,
                   id: Option[Long] = None)

trait ProductComponent { this: Profile =>
  import profile.simple._

  class Products(tag: Tag) extends Table[Product](tag, "PRODUCTS") {
    def name = column[String] ("NAME", O.NotNull)
    def burn = column[Int] ("BURN")
    def description = column[String] ("DESCRIPTION")
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)

    def * = (name, burn, description, id.?) <> (Product.tupled, Product.unapply)
  }

  // Query interface for products
  val products = TableQuery[Products]

  def allProducts(implicit session: Session): List[Product] = products.list

  def insert(m: Product)(implicit session: Session): Int = {
    val id: Int = products += m
    println("Inserted {}", m)
    id
  }
}

