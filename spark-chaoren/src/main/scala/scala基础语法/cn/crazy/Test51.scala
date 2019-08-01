package scala基础语法.cn.crazy

/**
 * 伴生对象
 */

class TestObject51{
  def display(){
    println(TestObject51.value)
  }
}

//同名类的伴生对象
object TestObject51{
  //对象是一个单独类型，提供类似java中的静态字段和静态方法功能
  private var value = 1
  
//  def show(){
//    println("hello world!")
//  }
}

object Test51 extends App{
//  TestObject51.show()   //调用object的方法
//  println(TestObject51.value)  //object中使用private修饰的字段外部不能访问
  
  var tmp = new TestObject51
  println(tmp.display())
}