package scala基础语法.cn.crazy

import scala.collection.mutable.ArrayBuffer
import java.util.ArrayList

/**
 * 数组
 */
object Test31 extends App{
  /*定长数组*/
  var arr1 = new Array[Int](4) //使用new的方式定义一个数组
  arr1(1) = 2
//  for( i <- arr1){
//    println(i)
//  }
  
  //利用Array类定义数组
//  var arr2 = Array(1,2,3,4,5,"hehe")
//  for(i <- arr2){
//    println(i)
//  }
  
  var arr3 = Array(1,2,3,4,5)
//  println(arr3.min)
//  println(arr3.max)
//  println(arr3.sum)
//  println(arr3.mkString(" ")) //Arrays.toString(arr)类似
  
  
  //使用for的推导式产生新的数组
  var arr4  = for( i <- arr3)yield i * 2
//  println(arr4)
//  for(i <- arr4){
//    println(i)
//  }
  
  /*变长数组*/
  var arr5 = ArrayBuffer[Int](1,2,3,4,5)
//  arr5 += 6           //添加一个元素
//  arr5 -= 1
//  arr5 ++= arr3     //添加一个数组
//  arr5 --= arr3       //删除数组中多个元素
//  println(arr5.mkString(","))
  
//  var arr6 = arr3.toBuffer  //定长数组转换为变长数组
//  arr6 += 7
//  println(arr6.mkString(","))
  
//  arr5.toArray     //变长数组转换为定长数组
  
//  var list = new ArrayList[Int]
//  list.add(1)
//  list.add(3)
//  for(i <- 0 to list.size() - 1){
//    println(list.get(i))
//  }
  
  //filter和map的用法
  var arr7 = Array(1,2,3,4,5)
  var arr8 = arr7.filter(_ % 2 == 0).map(_ * 2)
  var arr9 = arr7.filter{_ % 2 == 0}.map(_ * 2)
  
  for(i <- arr8){
    println(i)
  }
  
  
}