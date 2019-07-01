package cn.cxrxy

/**
 * 控制结构 while for
 */
object Test22 extends App{
  /*while循环*/
  //  while(true){
  //    println("hello")
  //  }

  /*for循环*/
  //  for(int i = 0 ; i < 4 ; i ++){} //java的for循环
  //  for( i : List){}

  //for的基本形态
  //  println(1 to 10)

  //  b.*(a)
  //  for( i <- 1 to 10){ //闭区间
  //    println(i)
  //  }

  //  for (i <- 1 until 10) { //开区间
  //    println(i)
  //  }

  //  for (i <- 1 until 10 reverse) { //倒序
  //    println(i)
  //  }

  /*高级for循环*/
  //守卫
//  for (i <- 1 until 10 reverse ;if i % 3 == 0) { //修改步长
//    println(i)
//  }

//  for (i <- 1 until 10 ; j <- 1 to 5) { //双重for循环
//      println(i + " - " + j)
//  }
  
  //for的推导式
  var tmp = for( i <- 1 to 10 )yield {i * 2 ; i + 1}
  println(tmp)
}