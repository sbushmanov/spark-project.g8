package $package$

import org.apache.spark.graphx._
import org.apache.spark.SparkContext._
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.{functions => F}

import org.apache.log4j.{Level, LogManager}
import org.apache.hadoop.fs.{FileSystem, Path}
import java.io.BufferedOutputStream

import Functions._
import Transformers._


object Main extends SparkSessionBuilder {

  LogManager.getLogger("org").setLevel(Level.ERROR)

  import spark.implicits._
  
  def main(args: Array[String]): Unit = {
    println(hello.toUpper)

    val data = Seq(1,2,3,4,5)
    val rdd = sc.parallelize(data)
    val count = rdd.count()

    // Print result
    println(s"Count of elements: \$count")
  }

}
