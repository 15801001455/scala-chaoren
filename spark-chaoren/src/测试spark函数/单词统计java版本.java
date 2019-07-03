package 测试spark函数;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.rdd.RDD;
import scala.Function;

/**
 * 待完善 还没找到代码
 */
public class 单词统计java版本 {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf();
        conf.setAppName("java版本单词统计");
        conf.setMaster("local");
        SparkContext sc = new SparkContext();
        RDD<String> rdd1 = sc.textFile("G:\\sparktest\\a.txt", 1);
        //rdd1.flatMap(new Function())

    }
}
