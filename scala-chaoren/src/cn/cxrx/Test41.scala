package cn.cxrx

import scala.beans.BeanProperty

/**
  * 类的基本内容
  */
class TestClass41{
  var money = 100//会自动生成set和get方法
  @BeanProperty var money1 = 2
  private var money2 = 3 //不再提供getter和setter方法了,和java不一样了，但是可以自己实现get和set，看Test42

  def add(): Unit ={
    println("")
  }
}

object Test41 extends App{
  //scala字段用var定义都会生成对应的setter（money_=）和getter(money)方法
  var a = new TestClass41
  a.money = 200//setter方法 完整写法是 a.money_=(200)
  a.money_=(300)//setter方法的完整写法，是不是和java区别太大，其实可以在class定义变量的时候加上@BeanProperty注解 就可以用类似java的getter和setter方法了，具体看money1变量
  println(a.money)

  //下面这两种和java类似 看着顺阳 因为money1变量上加了@BeanProperty注解才能setMoney1 getMoney1这么用的
  a.setMoney1(2)
  a.getMoney1()
}
