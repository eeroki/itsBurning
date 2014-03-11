import sbt._

// Versions
object Version {
	val akka = "2.2.1"
	val spray = "1.2-20131004"
	val sprayJson = "1.2.5"
	val slick = "2.0.0"
	val logback = "1.0.13"	
	val h2 = "1.3.166"
}

object Library {
	val akkaActor = "com.typesafe.akka" 	  %% "akka-actor" 	  % Version.akka
	val akkaslf4j = "com.typesafe.akka" 	  %% "akka-slf4j" 	  % Version.akka
	val sprayCan = "io.spray" 				      % "spray-can" 		  % Version.spray
	val sprayRouting = "io.spray" 			    % "spray-routing" 	% Version.spray
	val sprayTestkit = "io.spray"           % "spray-testkit" 	% Version.spray 			% "test"
	val sprayJson = "io.spray" 				      %% "spray-json" 	  % Version.sprayJson
	val slick = "com.typesafe.slick"  		  %% "slick"       	  % Version.slick
	val h2Database = "com.h2database"      	% "h2"        	    % Version.h2
	val logbackClassic = "ch.qos.logback" 	% "logback-classic" % Version.logback
}

object Dependencies {

	import Library._

	val itsBurning = List(
		akkaActor,
		akkaslf4j,
		sprayCan,
		sprayRouting,
		sprayTestkit,
		sprayJson,
		slick,
		h2Database,
		logbackClassic
	)
}