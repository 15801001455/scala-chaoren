package cn.cxrxy

/**
 * 函数
 */
object Test11 extends App{
  //  println("hello world!")

  /*无返回值的函数*/
  //  def add(a:Int ,b:Int){
  //    println(a + b)
  //  }
  //  add(1,2)

  /*有返回值的函数*/
  //scala中返回值显示为（）表示Unit
  //如果我们强制指定函数返回值类型为Unit，返回就为Unit类型
  def add(a: Int, b: Int) :Int = {
    a + b
  }
//  var a = add(2, 2)
//  println(a)
  
  /*小知识点*/
//  1.scala中，“;”可以加也可以不加
//  2.调用函数的时候，我们可以给定参数名进行调用
  
  var c = add(b = 2 , a = 2) //给定参数名进行调用
  println(c)
  
}