name := "Jenkins Test"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "org.scala-lang" % "scala-library" % "2.11.7"


libraryDependencies += "org.apache.spark" %% "spark-core" % "2.1.0" 
libraryDependencies += "org.mongodb.spark" % "mongo-spark-connector_2.11" % "2.0.0"
 
 
 assemblyMergeStrategy in assembly := {
 case PathList("META-INF", xs @ _*) => MergeStrategy.discard
 case x => MergeStrategy.first
}