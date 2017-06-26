name := "Jenkins Test"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "org.scala-lang" % "scala-library" % "2.11.7"


libraryDependencies += "org.apache.spark" %% "spark-core" % "2.1.0" 
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "2.1.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.1.0"


 libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.8.5"
 libraryDependencies += "com.fasterxml.jackson.core" % "jackson-annotations" % "2.8.5"
 libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.5"
 libraryDependencies += "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.8.5"
 libraryDependencies += "org.json4s" % "json4s-ast_2.11" % "3.2.11"
 libraryDependencies += "org.json4s" % "json4s-core_2.11" % "3.2.11"
 libraryDependencies += "org.json4s" % "json4s-jackson_2.11" % "3.2.11"
 libraryDependencies += "joda-time" % "joda-time" % "2.9.3"
 libraryDependencies += "org.jodd" % "jodd-core" % "3.5.2"

 libraryDependencies += "org.mongodb" % "casbah-commons_2.11" % "3.0.0"
 libraryDependencies += "org.mongodb" % "casbah-core_2.11" % "3.0.0"
 libraryDependencies += "org.mongodb" % "casbah-query_2.11" % "3.0.0"
 libraryDependencies += "com.typesafe.play" % "play-json_2.11" % "2.6.0-M2"
 libraryDependencies += "com.typesafe.play" % "play-functional_2.11" % "2.6.0-M2"
 libraryDependencies += "org.mongodb.spark" % "mongo-spark-connector_2.11" % "2.0.0"
 libraryDependencies += "org.apache.spark" % "spark-streaming_2.11" % "2.1.0"
 libraryDependencies += "org.apache.spark" % "spark-streaming-kafka-0-8_2.11" % "2.1.0"
 
 
 assemblyMergeStrategy in assembly := {
 case PathList("META-INF", xs @ _*) => MergeStrategy.discard
 case x => MergeStrategy.first
}