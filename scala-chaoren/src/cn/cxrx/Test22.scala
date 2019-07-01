package cn.cxrx

/**
  * 控制接口 while 和 for
  */
object Test22 extends App{
  /*和java一样*/
  /*while(true){
    println("hello")
  }*/

  /*for循环*/
  println(1 to 10)//是一个Range集合
  for(i <- 1 to 10){
    println(i)
  }
  //to 是什么呢？to是个方法名其实 (看看Test11中的*号也是个方法名)
  //所以可以写成下面这样
  for(i <- 1.to(10)){//闭区间
    println(i)
  }

  //开区间
  for(i <- 1 until 10){//不会打印10
    println(i)
  }

  //倒着怎么循环呢? 不能写成 10 to 1
  for(i <- 1 to 10 reverse){
    println(i)
  }

  /**
    * for(i <- 1 to 10 reverse){
    * println(i)
    * }这个reverse放到这里好突兀 其实是下面的简写
    */
  for(i <- (11 to 12).reverse){
    println(i)
  }

  //高级for循环
  //守卫 for(i <- 1 to 10 if i % 2 == 0)
  for(i <- 1 to 10 if i % 2 == 0){//修改步长 打印2,4,6,8,10
    println(i)
  }
  //双重for循环
  for(i <- 1 to 10){
    for(j <-1 to 10){
      println(i + "," + j)
    }
  }
  //双重for循环的简便写法
  for(i <- 1 to 10;j <- 1 to 5){
    println(i + "!" + j)
  }
  println("**********************************")
  /**
    * 下面这种yield是for的推导式 就相当于java代码中的
    * "List list = new ArrayList();
    * for(int i=0;i<2;i++){
    *   list.add(i*2);
    * }
    * 然后再循环list操作 是不是很繁琐呢java,用scala的yield是不是很简单呢
    */
  var tmp = for(i <- 1 to 2)yield i * 2
  println(tmp)
  var tmp1 = for(i <- 1 to 2)yield (i * 2)
  println(tmp1)
  var tmp2 = for(i <- 1 to 2)yield {i * 2}//这写法也太灵活了 大括号 小括号都行
  println(tmp2)
  //那么下面这种返回什么呢>?
  var tmp3 = for(i <- 1 to 2)yield{i * 2}//中间连着也行!
  println(tmp3)
  var tmp4 = for(i <- 1 to 2)yield {i * 2;i+1}//这种只会返回i+1的结果,记住只能返回最后一行的值
  println(tmp4)
}
