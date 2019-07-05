package 常用函数测试

import org.apache.spark.{SparkConf, SparkContext}

/**
  * aggregate 本地模式
  *
  * //分析：
  * 初始值为2(再求最大值和最后相加部分都会加上初始值2这个因子)，
  *   partition 0 求最大值（2,1,2,3）得到最大值 3
  *   partition 1 求最大值（2,4,5,6,7）得到最大值 7
  *   全局聚合 2+3+7=12
  */
object Aggregate测试 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("LocalSpark")
    val sc = new SparkContext(conf)
    val z = sc.parallelize(List(1,2,3,4,5,6,7),2)
    //val z = sc.parallelize(List(1,2,3,4,5,6))
    println(z.aggregate(2)(math.max(_,_),_+_))//结果是：
  }

}
