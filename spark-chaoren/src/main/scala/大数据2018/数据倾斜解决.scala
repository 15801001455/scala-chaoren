package 大数据2018

import org.apache.spark.{SparkConf, SparkContext}

import scala.util.Random

/**
  * 数据倾斜产生的问题出现在reduceByKey,某一个单词出现的次数过多，会过多到一个节点进行计算，导致单节点计算压力变大
  * 解决方法：
  *     在reduceByKey之前重新设计key，使key均匀分布进行打乱，然后在reduceByKey,再想办法
  *     把打乱的key重新汇总
  */
object 数据倾斜解决 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setAppName("WordCountScala")
    conf.setMaster("local[4]") ;
    val sc = new SparkContext(conf)
    val rdd1 = sc.textFile("G:/sparkTest/数据倾斜.txt")
    rdd1.flatMap(_.split(",")).map((_,1)).reduceByKey(_ + _).foreach(line => {
      println(line._1 + "," + line._2)
    });
    println("解决办法如下：")
    rdd1.flatMap(_.split(",")).map(word => {
      val nextInt = Random.nextInt(100);
      (word +"_"+ nextInt,1)
    }).reduceByKey(_ + _).map(tuple => {
      (tuple._1.split("_")(0),tuple._2)
    }).reduceByKey(_ + _,4).foreach(line => {
      println(line._1 + "," + line._2)
    })
  }
}
