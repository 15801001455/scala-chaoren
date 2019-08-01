package scala基础语法.cn.crazy

/**
 * 高阶函数
 */

object Test61 extends App{
  
  //定义一个有返回值的函数
//  def add(a:Int , b:Int) = {
//    a + b
//  }
//  var c = add(1,2)
//  println(c)
  
  
  //把一个函数传递给另外一个函数
//  var func1 = add _   
//  println(func1(1,1))
  
  
  //匿名函数
  var func2 = (x:Int) => {x + 2}
//  println(func2(1))
  
  
  //传递一个函数作为另外一个函数的参数类型
  def func3(a:Int , f:(Int) => (Int)) = {
    f(1) + 1
  }
//  println(func3(func2))  
  println(func3(1, (x:Int) => {x + 1}))
  println(func3(1, _ + 1))
/*  转换条件：
    1.只有一个形参
    2.匿名函数作为参数
    3.函数体只有一行代码*/
  
  
  //传递一个函数作为另外一个函数的应用场景
//  def GPU(a:Int) = {
//    a + 3
//  }
//  def CPU(b:Int) = {
//    b + 10
//  }
//  def compute(men:Int , CPU:(Int) => (Int),GPU:(Int) => (Int)) = {
//   men +  CPU(2) + GPU(1)
//  }
//  println(compute(4,CPU,GPU))
  
  // "_"所代表的意义 
//  1.用来取元组的值
//  2.指传递的是一个确切的函数
//  3.指每一个元素 
  
  
}