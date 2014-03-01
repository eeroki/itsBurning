package itsburning.domain


import org.slf4j.LoggerFactory
import org.slf4j.Logger
import scala.slick.driver.JdbcProfile


trait Profile {
  val profile: JdbcProfile
}

class DAL(override val profile: JdbcProfile) extends ProductComponent with Profile {
  import profile.simple._

  val logger: Logger = LoggerFactory.getLogger("itsBurning.domain")
  logger.info("DBModel instantiated")

  def create(implicit session: Session): Unit = (products.ddl).create

  def drop(implicit session: Session): Unit = (products.ddl).drop
}
