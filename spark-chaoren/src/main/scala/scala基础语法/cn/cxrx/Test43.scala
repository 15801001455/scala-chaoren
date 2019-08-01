package scala基础语法.cn.cxrx

/**
  * 类的构造器 记住一定把scala的类当成是方法来看待 后面可以加参数的
  * 记住一定把scala的类当成是方法来看待 就好理解scala的类了
  */
//TestClass43 这种叫做主构造器
class TestClass43(a:Int = 1,b:Int = 2){
  println(a + b)//不用java的main方法都可以直接这么用，因为类就是方法 方法可以嵌套方法
}

//TestClass43_1 这种叫做辅助构造器
class TestClass43_1(){
  var a:Int = 1
  var b:Int = 2

  //辅助构造器的名字就叫做this
  def this(a:Int){
    this()//辅助构造器第一行必须调用主构造器或者其他辅助构造器
    this.a = a
  }

  def this(a:Int,b:Int){
    this(a)
    this.b = b
  }

  //println(a + b) 用辅助构造器就不能在这里打印了，要不会一直打印1+2=3
}

object Test43 extends App{
  var a = new TestClass43()
  var b = new TestClass43(10)//相当于a=10
  var c = new TestClass43(10,15)//相当于a=10 b=15

  var d = new TestClass43_1()
  println(d.a + d.b)
  var e = new TestClass43_1(10)
  println(e.a + e.b)
  var f = new TestClass43_1(10,12)
  println(f.a + f.b)
}
