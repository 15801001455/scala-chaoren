package scala基础语法.cn.cxrx

/**
  * 高阶函数
  */
object Test61 extends App{
  def add(a:Int,b:Int): Int ={
    a + b
  }
  //把一个函数传递给另一个函数
  var func1 = add _
  println(func1(1,2))

  //匿名函数
  var func2 = (x:Int) => {x + 2}
  println(func2(11))

  //传递一个函数作为另一个函数的参数类型
  def func3(f:(Int) => (Int)): Int ={
    f(1)
  }
  println(func3(func2))
  println(func3((x:Int) => {x+x}))
  println(func3(_ + 1))//能这么简写的条件比较苛刻 看看就好

  //"_"所代表的意义
  /**
    * 1.用来取元组的值
    * 2.指传递的是一个确切的函数
    * 3.指每一个元素
    */

}
