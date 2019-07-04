package 测试spark函数;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.rdd.RDD;
import scala.Function;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * java版本wordcount
 * map和flatMap 区别
 *     flatMap会把一行炸裂成多行
 *     map一行还是返回一行
 */
public class 单词统计java版本 {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf();
        conf.setAppName("java版本单词统计");
        conf.setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        //读取文件
        JavaRDD<String> rdd1 = sc.textFile("G:\\apache-cxf-3.3.0\\LICENSE");
        //处理文件的每一行进行爆炸成多行
        JavaRDD<String> rdd2 = rdd1.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String line) throws Exception {
                String[] splitWithWords = line.split("\\s+");
                List<String> list = new ArrayList<>();
                for (String splitWithWord : splitWithWords) {
                    list.add(splitWithWord);
                }
                return list.iterator();
            }
        });
        JavaPairRDD<String, Integer> rdd3 = rdd2.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<>(s,1);
            }
        });
        JavaPairRDD<String, Integer> rdd4 = rdd3.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer a, Integer b) throws Exception {
                return a + b;
            }
        });
        List<Tuple2<String, Integer>> list = rdd4.collect();
        for(Tuple2<String, Integer> tuple : list){
            System.out.println(tuple._1 + "," + tuple._2);
        }

    }
}
