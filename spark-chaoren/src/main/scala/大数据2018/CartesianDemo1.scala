package 大数据2018

import org.apache.spark.{SparkConf, SparkContext}

/**
  * 笛卡尔积 就是给出所有组合可能 返回元组的集合
  */
object CartesianDemo1 {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf()
        conf.setAppName("WordCountScala")
        conf.setMaster("local[4]") ;
        val sc = new SparkContext(conf)
        val rdd1 = sc.parallelize(Array("tom","tomas","tomasle","tomson"))
        val rdd2 = sc.parallelize(Array("1234","3456","5678","7890"))

        val rdd = rdd1.cartesian(rdd2);
        rdd.collect().foreach(println)
    }
}
