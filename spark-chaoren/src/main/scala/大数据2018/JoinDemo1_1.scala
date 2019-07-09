package 大数据2018

import org.apache.spark.{SparkConf, SparkContext}

/**
  * JoinDemo1的自我练习
  * 测试数据
  * names.txt
  *     1,张三
  *     2,李四
  *     3,王五
  * scores.txt
  *     1,100
  *     2,90
  *     3,60
  *     3,120
  *     4,20(join不到一块的会被抛弃)
  *
  *  一会测试不均等数据
  *  XXX
  */
object JoinDemo1_1 {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf()
        conf.setAppName("join")
        conf.setMaster("local") ;
        val sc = new SparkContext(conf)

        val nameRDD = sc.textFile("G:/sparktest/names.txt")
        var nameMap = nameRDD.map(line => {
            val lineArr = line.split(",");
            (lineArr(0),lineArr(1))
        })

        val scoreRDD = sc.textFile("G:/sparktest/scores.txt")
        var scoreMap = scoreRDD.map(line => {
            val lineArr = line.split(",");
            (lineArr(0),lineArr(1))
        })
        val joinRDD = nameMap.join(scoreMap).sortByKey()
        joinRDD.collect.foreach(t => {
            println(t._1 + "," + t._2._1 + "," + t._2._2)
        })
    }
}
