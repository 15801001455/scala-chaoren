package scala基础语法.cn.cxrx

/**
  * 函数
  */
object Test11 extends App {
//  println("hello world")

  /*无返回值的函数*/
  /*def add(a:Int,b:Int): Unit ={
    println(a + b)
  }
  add(1,2)*/

  /*有返回值的函数
  * 函数最后一行就为返回值 不用写return
  *
  * */
  def add(a:Int,b:Int):Int ={
    a - b
  }
  var a =add(1,2)
  println(a)

  /**
    * 调用函数可以指定参数名称
    */
  var d = add(b = 3,a=4)
  println(d)

  //var e = add(b = 3,4) 错误,有二义性 所以错误
  //var e = add(a = 3,4)//正确


}
