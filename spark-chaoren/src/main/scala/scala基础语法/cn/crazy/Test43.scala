package scala基础语法.cn.crazy

/**
 * 类的构造器
 */

//主构造器
//class TestClass43(var a:Int = 1 , var b:Int = 2) {
//  var a:Int = 1
//  var b:Int = 2
//  println(a + b)
//}

//辅助构造器
class TestClass43 {
  var a:Int = 0
  var b:Int = 0
  
  def this(a:Int){
    this()    //辅助构造器第一行必须要调用主构造器
    this.a = a
    println("第一个辅助构造器")
  }
  
  def this(a:Int , b:Int){
    this(a)   //除了调用主构造器之外还可以调用其他辅助构造器
    this.a = a
    this.b = b
    println("第二个辅助构造器")
  }
  
  println(a + b)
  
  def show {
    println(a + b)
    println("show方法")
  }
  
}

object Test43 extends App{
  val c = new TestClass43(1,2)
//  println(c.a + c.b)
  println(c.show)
}