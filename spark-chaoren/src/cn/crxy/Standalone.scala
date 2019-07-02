package cn.crxy

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

/**
 * spark standalone模式任务提交
 */
object Standalone {
  def main(args: Array[String]){
    if(args.length != 2){
      System.err.println("Usage : <inputpath> <outpath>")
      System.exit(1)
    }
    
    val conf = new SparkConf()                          //构造SparkConf对象
    conf.setSparkHome("/opt/software/spark-2.4")  //spark的安装目录
    conf.setMaster("spark://docker:7077")              //spark master url
    conf.setAppName("StandaloneSpark")                  //app名称
    conf.set("SPARK_EXECUTOR_MEMORY", "2g")             //配置spark executor内存
    
    val sc = new SparkContext(conf)   //构造SparkContext对象
    
    val file = sc.textFile(args(0))   //加载文件
    
    file.cache                        //序列话到内存
    
    val tmp = file.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).sortByKey(false)
    
    tmp.repartition(1).saveAsTextFile(args(1))
  }
}