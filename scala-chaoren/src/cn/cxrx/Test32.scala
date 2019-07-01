package cn.cxrx

/**
  * 映射
  *   可变map
  *   不可变map map的key所对应的value不可变 而不是不能往map中增加或者删除键值对！
  */
object Test32 extends App{
  var map1 = Map[String,Int]("zhangsan"->18,"lisi"->14)
  for(i <- map1){
    println(i) //(zhangsan,18)打印出来的键值对称作对偶(对偶是元组的最简单形式) 对偶用()表示
  }

  //还可以下面这么写
  var map2 = Map[String,Int](("zhangsan",18),("lisi",20))
  for(i <- map2){
    println(i)
  }
  println("*****************")
  //往map中加入元素
  map1 += ("wangwu" -> 10)
  for(i <- map1){
    println(i)
  }
  println("---------------")
  //给map中的一个元素赋值
  //map1("zhangsan") = 28//这样是不对的，虽然编译不报错，因为这种map是不可变map
  //可以间接的这么改，因为map的key是不能重复的，所以重新加入zhansan的键就相当于编辑修改了
  map1 += ("zhangsan" -> 28)
  for(i <- map1){
    println(i)
  }

  //添加判断key是否存在，否则会报错
  if(map1.contains("zhangliu")){
    println(map1("zhangliu"))
  }

  //拿出所有的key和value
  for((k,v) <- map1){
    println(k + "," + v)
  }

  //拿出所有的key
  var tmp = map1.keys
  println(tmp)//Set(zhangsan, lisi, wangwu)
  var tmp1 = map1.keySet
  println(tmp1)//Set(zhangsan, lisi, wangwu) 所以keys和keySet都一样等价
  for(i <- tmp1){
    println(i + "," + map1(i))
  }

  println("上面都是不可变映射")

  /*可变的映射*/
  var map3 = scala.collection.mutable.Map[String,Int]("zhangsan"->13,"lisi"->14)
  map3("zhangsan") = 23
  for(i <- map3){
    println(i)
  }
}
