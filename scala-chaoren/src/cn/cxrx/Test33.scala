package cn.cxrx
/**
  * 元组
  */
object Test33 extends App{
  var t = ("张三",2,"lisi","王五")
  println(t._3)//元组下标从1开始的 使用._(下标)
  println(t _1)//简单写法
  var (a,b,c,d) = t//利用模式匹配访问元组的元素
  println(a)
  //其中某些元素不想匹配,可以用_代替
  var (e,_,_,g) = t
  println(g)

  //元组的一个实际应用场景
  var s = "Hello World"
  println(s.partition(_.isUpper))//(HW,ello orld) 大写和非大写字符分开了
  var (h,w) = s.partition(_.isUpper)
  println(h)

  //拉链操作 两个数组进行组合,然后toMap就叫做拉链操作，不知道为啥这么叫
  var arr1 = Array(1,2,3)
  var arr2 = Array("a","b","c")
  var arr3 = arr1.zip(arr2)
  println(arr3)
  var arr4 = arr3.toMap
  println(arr4)
  for(i <- arr4){
    println(i)
  }
}
