package scala基础语法.cn.crazy

/**
 * 映射
 */
object Test32 extends App{
  /*不可变的映射*/
  //(zhangsan,17) 键值对称作对偶   对偶用（）
  var map1 = Map[String , Int]("zhangsan" -> 17 , "lisi" -> 18)
  map1 += ("wangwu" -> 10)
//  map1 += ("zhaoliu",80)
//  for(i <- map1){
//    println(i)
//  }
  
  //给对应key更改value
//  map1("zhangsan") = 18
  map1 += ("zhangsan" -> 18)
//  for (i <- map1) {
//    println(i)
//  }
  
//  if(map1.contains("zhaoliu")) //添加判断 验证key是否存在
//    println(map1("zhaoliu"))
    
//    for((k , v) <- map1){  //使用（k,v）遍历map
//      println(k + " -> " + v)
//    }
  
//  var tmp = map1.keys
//  var tmp1 = map1.keySet
//  println(tmp1)
//  for(i <- tmp){    //利用keyset取出map的值
//    println(map1(i))
//  }
    
  /*可变的映射*/
  var map2 = scala.collection.mutable.Map[String,Int]("zhangsan"->18,"lisi"->19)
  map2("zhangsan") = 19
  for( i <- map2){
    println(i)
  }
}