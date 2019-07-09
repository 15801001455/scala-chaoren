package 大数据2018

;
import org.apache.spark.{SparkConf, SparkContext}

/**
  * 各种统计单词的方式
  */
object WordCountScala_01 {
    def main(args: Array[String]): Unit = {
        //创建Spark配置对象
        val conf = new SparkConf()
        conf.setAppName("WordCountScala_01")
        conf.setMaster("local") ;
        val sc = new SparkContext(conf)
        val rdd1 = sc.textFile("G:/sparktest/a.txt")
        println(rdd1.flatMap(_.split(",")).count())
        println(rdd1.map(_.split(",").length).reduce(_ + _))
    }
}
