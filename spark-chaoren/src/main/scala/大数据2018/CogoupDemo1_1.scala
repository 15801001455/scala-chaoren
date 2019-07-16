package 大数据2018

import org.apache.spark.{SparkConf, SparkContext}

/**
  * cogroup自我练习 对比JoinDemo1_1这个类看和join函数的区别
  * (K,V) cogroup (K,W) -> (K,(Interator<V>,Iterator<W>)) 注意这个像是左连接或者右连接，及时左边有右边没有的K也会出现在
  *                    最终结果中，这个是和Join函数(相当于mysql中的 inner join)的区别
  *
  *  cogroup-1.txt
  *         a,张三
  *         a,李四
  *         b,李四
  *         b,张三
  *         c,王五
  *  cogroup-2.txt
  *         a,1
  *         a,2
  *         b,1
  *         b,2
  */
object CogoupDemo1_1 {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf()
        conf.setAppName("WordCountScala")
        conf.setMaster("local") ;
        val sc = new SparkContext(conf)
        val rdd1 = sc.textFile("G:/sparktest/cogroup-1.txt")
        //K,V
        val rdd2 = rdd1.map(line=>{
            val arr = line.split(",")
            (arr(0),arr(1))
        })

        //K,W
        val rdd3 = sc.textFile("G:/sparktest/cogroup-2.txt")
        //key,value
        val rdd4 = rdd3.map(line => {
            val arr = line.split(",")
            (arr(0), arr(1))
        })

        val rdd = rdd2.cogroup(rdd4)
        rdd.collect().foreach(t => {
            println(t._1)
            println("---------------")
            for(e <- t._2._1){
                println(e)
            }
            for(e <- t._2._2){
                println(e)
            }
            println("---------------")
        })
    }
}
