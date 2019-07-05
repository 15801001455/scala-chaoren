package 常用函数测试

import org.apache.spark.{SparkConf, SparkContext}

/**
  * 作用于相同key的value,初始值只作用于局部聚合，而不作用于全局聚合
  *
  * // 底层调用了combineByKey
  * def aggregateByKey[U](zeroValue: U)(seqOp: (U, V) ⇒ U, combOp: (U, U) ⇒ U)(implicit arg0: ClassTag[U]): RDD[(K, U)]
  * // zeroValue: U 自定义的初始值
  * // (seqOp: (U, V) ⇒ U 局部聚合函数，返回类型为U类型
  * // combOp: (U, U) ⇒ U 全局聚合，返回类型为U类型
  * def aggregateByKey[U](zeroValue: U, numPartitions: Int)(seqOp: (U, V) ⇒ U, combOp: (U, U) ⇒ U)(implicit arg0: ClassTag[U]): RDD[(K, U)]
  * // numPartitions: Int 分区数
  * def aggregateByKey[U](zeroValue: U, partitioner: Partitioner)(seqOp: (U, V) ⇒ U, combOp: (U, U) ⇒ U)(implicit arg0: ClassTag[U]): RDD[(K, U)]
  * // partitioner: Partitioner 分区器
  */
/**
  * dog,4
  * cat,17
  * mouse,3
  */
object aggregateByKey测试 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("LocalSpark")
    val sc = new SparkContext(conf)
    val pairRDD = sc.parallelize(List(("cat",2),("dog",4),("mouse",3),("cat",15)),2)
    val tuples = pairRDD.aggregateByKey(0)(math.max(_,_),_+_).collect()
    for(t <- tuples){
      println(t._1 + "," + t._2)
    }
  }
}
