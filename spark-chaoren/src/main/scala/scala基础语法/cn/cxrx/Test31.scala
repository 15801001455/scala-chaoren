package scala基础语法.cn.cxrx

import java.util

import scala.collection.mutable.ArrayBuffer
import java.util.ArrayList
/**
  * 数组
  */
object Test31 extends App{
  var arr1 = new Array[Int](5)
  arr1(1) = 2
  for(i <- arr1){
    println(i)
  }
  var arr2 = Array(1,2,3,4,5,"haha")//数组可以放不同类型，但是指定泛型就不行了
  //var arr2 = Array[Int](1,2,3,4,5,"haha")//错误
  for(i <- arr2){
    println(i)
  }
  println(arr1.min);
  println(arr1.max);
  println(arr1.sum);
  println(arr2.mkString("|"))//相当于java Arrays.toString(arr)

  println("---------------")

  //一个数组产生一个新的数组
  var arr4 = for(i<- arr1)yield i * 2
  for(i <- arr4){
    println(i)
  }

  println("上面的讲解的都是定长数组")

  /*变长数组*/
  var arr5 = ArrayBuffer[Int](1,2,3,4,5)
  arr5 += 6
  arr5 -= 1
  arr5 ++= arr1 //变长数组加上一个定长数组
  println(arr5.mkString(","))

  /*定长转成变长*/
  var arr6 = arr1.toBuffer
  arr6 += 7
  println(arr6)

  /*变长转成定长*/
  var arr7 = arr5.toArray
  println(arr7)

  /*scala引用java的东西*/
  var list = new ArrayList[Int]
  list.add(1)
  list.add(3)
  for(i <- 0 to list.size()-1){
    println(list.get(i))
  }

  println("****************")

  var arr8 = Array(1,2,3,4,5)
  var arr9 = arr8.filter(_ % 2 == 0)//_下划线代表每一个元素
  println(arr9.mkString(","))
  var arr10 = arr8.filter(_ % 2 == 0).map(_ * 2)
  println(arr10.mkString(","))
  //上面还可以用大括号  真是乱
  var arr11 = arr8.filter{_ % 2 == 0}.map(_ * 2)
  var arr12 = arr8.filter{_ % 2 == 0}.map{_ * 2}
  println(arr11.mkString("|") + "," + arr12.mkString("|"))
}
