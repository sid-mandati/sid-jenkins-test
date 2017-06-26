package com.jenkinstest



import org.apache.spark.{SparkConf,SparkContext}

import org.apache.spark.sql.{SQLContext,Row,Column,DataFrame}


import org.joda.time._
import org.joda.time.format._

import com.mongodb.casbah._

import com.mongodb.DBObject
import com.mongodb.casbah.MongoClientURI
import com.mongodb.util.JSON



object JenkinsTestScala {
  def main(args: Array[String]){
    println("1")
    System.setProperty("user.timezone", "UTC")
    //println("ETL started at " + new DateTime())
    println("2")
    val etl_start_time = new DateTime()
   println("3")
    
    val sparkConf = new SparkConf().setAppName("Reno_ETL")
    .setMaster("local[4]")
    println("4")
    val sc = new SparkContext(sparkConf)
    println("4")
    sc.setLogLevel("ERROR")
    println("5")
    val sqlContext = new SQLContext(sc) 
    println("6")
    val mongoIP = "127.0.0.11:27017"
    println("7")
    //val mongoClient = MongoClient("30.0.1.142", 27017)
    val mongoClient = MongoClient("127.0.0.11", 27017)
    println("8")
    val etlConfigDBName = "etl_config"
    println("9")
    val etlConfigCollName = "reno_etl_config"
    println("10")
    val etlConfigConnectionURI = "mongodb://"+mongoIP+"/"+etlConfigDBName
    println("11")
    println(mongoClient.databaseNames())
    //Get Config Details
    val etlConfigDf = sqlContext.read.format("com.mongodb.spark.sql.DefaultSource")
                    .option("spark.mongodb.input.uri", etlConfigConnectionURI)
                    .option("spark.mongodb.input.collection", etlConfigCollName)
                    .load()
    println("12")               
    val testingprint = etlConfigDf.select("ods_db_name").head().getString(0)
    println("13")
    println("test String is " + testingprint)
    
    sc.stop()
  }
}