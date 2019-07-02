package 测试spark函数

import org.apache.spark.{SparkConf, SparkContext}

object Aggregate测试 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()

    val sc = new SparkContext(conf)
    val z = sc.parallelize(List(1,2,3,4,5,6),2)
    println(z.aggregate(5)(math.max(_,_),_+_))
  }

}
