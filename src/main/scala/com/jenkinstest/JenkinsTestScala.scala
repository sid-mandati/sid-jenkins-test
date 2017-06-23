package com.jenkinstest


import org.apache.spark.streaming._
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf,SparkContext}

import play.api.libs.json._
import play.api.libs.functional._
import org.apache.spark.sql.{SQLContext,Row,Column,DataFrame}
import java.util.HashMap

import scala.collection.mutable.ArrayBuffer
import org.apache.spark.sql.functions.{unix_timestamp, to_date}
import org.apache.spark.sql.types._
import org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema
import org.apache.spark.sql.functions._

import java.util.Calendar
import java.text.SimpleDateFormat 

import org.json4s._
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._
import org.json4s.DefaultFormats

import com.mongodb.spark._
import com.mongodb.spark.sql._
import com.mongodb.spark.config._

import org.joda.time._
import org.joda.time.format._

import com.mongodb.casbah._

import com.mongodb.casbah.MongoClient
import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.casbah.commons.MongoDBList
import com.mongodb.casbah.query.Imports._

import com.mongodb.DBObject
import com.mongodb.casbah.MongoClientURI
import com.mongodb.util.JSON

import com.mongodb.casbah.commons.conversions.scala._ 
import scala.collection.immutable


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
    
    
    //Get Config Details
    val etlConfigDf = sqlContext.read.format("com.mongodb.spark.sql.DefaultSource")
                    .option("spark.mongodb.input.uri", etlConfigConnectionURI)
                    .option("spark.mongodb.input.collection", etlConfigCollName)
                    .load()
                    
    val testingprint = etlConfigDf.select("ods_db_name").head().getString(0)
    println("test String is " + testingprint)
  }
}