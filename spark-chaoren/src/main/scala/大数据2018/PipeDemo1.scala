package 大数据2018

import org.apache.spark.{SparkConf, SparkContext}

/**
  *  Pipe实验没有成功,以后再看
  */
object PipeDemo1 {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf()
        conf.setAppName("WordCountScala")
        conf.setMaster("local[4]") ;

        val sc = new SparkContext(conf)
        val rdd = sc.parallelize(Array("file:///d:","file:///e:","file:///f:",3))
        val rdd0 = rdd.pipe("dir ")
        rdd0.collect().foreach(println)
    }
}
