package cn.cxrx

/**
  * 对象 scala中没有java的静态字段和静态方法功能，通过对象实现
  */
object TestObject51{
  var value = 1
  private var value1 = 2//object中的使用private修饰的字段外部不能访问
  def show(): Unit ={
    println("hello world")
  }
}

class TestObject51{
  def display(): Unit ={
    //这里就能访问到TestObject51 object的private方法或者对象了
    println(TestObject51.value1)
  }
}

object Test51 extends App{
  println(TestObject51.value)
  TestObject51.show()
  //TestObject51.value1   object中的使用private修饰的字段外部不能访问
  /**
    * object中的使用private修饰的字段外部不能访问，
    * 那么我就想访问怎么办 可以使用object对象的伴生对象间接访问
    * 见本文件内的类TestObject51(和TestObject51 object同名的类叫做伴生对象)
    * new TestObject51就可以了
    */
  var a = new TestObject51
  a.display()//通过伴生对象间接取出了object的private方法
}
