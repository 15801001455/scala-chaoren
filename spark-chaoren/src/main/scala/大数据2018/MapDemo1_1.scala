package 大数据2018

import org.apache.spark.{SparkConf, SparkContext}

/**
  * 拷贝MapDemo1 进行学习
  */
object MapDemo1_1 {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf()
        conf.setAppName("WordCountScala")
        //conf.setMaster("local[4]") ; 4个线程
        conf.setMaster("local")
        val sc = new SparkContext(conf)

        //val rdd1 = sc.textFile("G:/sparktest/a.txt",4) 4个分区，实际可能多于设置的分区，要跟源代码
        val rdd1 = sc.textFile("G:/sparktest/a.txt",2)
        val rdd2 = rdd1.flatMap(_.split(",")) ;
        rdd2.map((_,1)).reduceByKey(_ + _).collect().foreach(println)
        rdd2.map(word => (word,1)).reduceByKey(_ + _).collect().foreach(println)
        println("**************************")
        rdd2.map(word => {
            println("start map")
            val t = (word,1)
            println(t._1)
            println("end map")
            t
        }).reduceByKey(_ + _).collect().foreach(println)
        println("&********************************************")
        println("mapPartition和map的区别就是 map一次处理一行,返回一行 mapPartition一次处理一个partition的多行,返回多行")
        println("那么有几个partition来处理呢？我的理解是设置sc.textFile的第二个参数一般没问题")
        rdd2.mapPartitions(it => {
            println("start mapPartitions")
            import scala.collection.mutable.ArrayBuffer
            val  buffer = ArrayBuffer[String]()
            for(e <- it){
                buffer.+=("_" + e)
            }
            println("end mapPartitions")
            buffer.iterator
        }).map((_,1)).reduceByKey(_ + _).collect().foreach(println)
        /*
        val rdd4 = rdd5.reduceByKey(_ + _)
        val r = rdd4.collect()
        r.foreach(println)*/
    }
}
