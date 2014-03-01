version       := "0.1"

scalaVersion  := "2.10.3"

name := "itsBurning"

seq(Revolver.settings: _*)

resolvers += "spray repo" at "http://repo.spray.io"

resolvers += "spray nightlies" at "http://nightlies.spray.io"

libraryDependencies ++= Dependencies.warbuilder

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

// webapp task
resourceGenerators in Compile <+= (resourceManaged, baseDirectory) map { (managedBase, base) =>
  val webappBase = base / "src" / "main" / "webapp"
  for {
    (from, to) <- webappBase ** "*" x rebase(webappBase, managedBase / "main" / "webapp")
  } yield {
    Sync.copy(from, to)
    to
  }
}

// watch webapp files
watchSources <++= baseDirectory map { path => ((path / "src" / "main" / "webapp") ** "*").get }