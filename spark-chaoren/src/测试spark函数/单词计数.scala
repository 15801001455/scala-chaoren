package 测试spark函数

/**
  * 完整版:
  *   val rdd2 = sc.textFile("/opt/sparktest/a.txt").flatMap(line => line.split(",")).map(line => (line,1)).reduceByKey(_ + _).collect
  * 简写：
  *   val rdd2 = sc.textFile("/opt/sparktest/*").flatMap(_.split(",")).map((_,1)).reduceByKey(_ + _).collect
  * 简写依据:
  *   1. =>右边只有一个左边的变量 可以下划线代替
  *   2. _ + _ 表示 两个结果相加再赋值给第一个下划线
  *
  * map和flatMap区别：
  *     map会返回和以前一样的行数
  *     flatMap会炸裂数据 原本一行返回多行数据
  */
object 单词计数 {
  def main(args: Array[String]): Unit = {



  }
}
