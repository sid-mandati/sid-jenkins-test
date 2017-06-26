package com.jenkinstest



import org.apache.spark.{SparkConf,SparkContext}

import org.apache.spark.sql.{SQLContext,Row,Column,DataFrame}


import org.joda.time._
import org.joda.time.format._

import com.mongodb.casbah._

import com.mongodb.DBObject
import com.mongodb.casbah.MongoClientURI
import com.mongodb.util.JSON



object JenkinsTestScala2 {
  def main(args: Array[String]){
    println(args(0))

  }
}