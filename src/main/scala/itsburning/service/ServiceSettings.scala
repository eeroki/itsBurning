package itsburning.service

import akka.actor.{ExtensionKey, Extension, ExtendedActorSystem}
import scala.concurrent.duration.{Duration, FiniteDuration, MILLISECONDS}

object ServiceSettings extends ExtensionKey[ServiceSettings]

class ServiceSettings(system: ExtendedActorSystem) extends Extension {
  val host: String = system.settings.config getString "service.host"
  val port: Int = system.settings.config getInt "service.port"
  val timeout: FiniteDuration = Duration(system.settings.config getMilliseconds "service.timeout", MILLISECONDS)
}
