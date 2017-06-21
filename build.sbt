name := "Jenkins Test"

version := "1.0"

scalaVersion := "2.11.7"

mainClass in Compile := Some("com.jenkinstest.JenkinsTestScala")

 assemblyMergeStrategy in assembly := {
 case PathList("META-INF", xs @ _*) => MergeStrategy.discard
 case x => MergeStrategy.first
}