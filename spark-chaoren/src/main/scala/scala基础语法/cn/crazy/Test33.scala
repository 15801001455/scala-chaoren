package scala基础语法.cn.crazy

/**
 * 元组
 */
object Test33 extends App{
  /*元组*/
  //对偶是元组最简单的形式  也是用（）
  var t = (1,2,3,4,"haha")  //元组的定义
//  println(t._1)      //使用._(下标) 
//  println(t _5)      //使用._(下标) 
//  println(t.productIterator)
//  for(i <- t.productIterator){
//    println(i)
//  }
  
//  var (first,second,third,_) = t //利用模式匹配访问元组元素
//  println(third)
  
  var s = "Hello World!"
//  println(s.partition {_.isUpper}) //返回值不是一个
  
  
  /*拉链操作*/
  var arr1 = Array(1,2,3,4,"##")
  var arr2 = Array("a","b","c","d")
  var arr3 = arr1.zip(arr2)
  println(arr3.mkString(","))
//  for(i <- arr3){
//    println(i)
//  }
  
//  var arr4 = arr3.toMap
//  println(arr4)
//  for(i <- arr4){
//    println(i)
//  }
  
  
}