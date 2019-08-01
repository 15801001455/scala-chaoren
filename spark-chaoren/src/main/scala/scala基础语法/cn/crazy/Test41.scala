package scala基础语法.cn.crazy

import scala.beans.BeanProperty

/**
 * 类的基本内容1
 */
class TestClass41{
  var monary = 100
  
}

object Test41 extends App{
  
  //scala中class的字段用var定义都会生成对应的setter和getter方法 ，名称分别为monary_= 和 monary
  //如果class中使用val定义 scala不在提供setter方法
  var a = new TestClass41
//  a.monary = 200
  println(a.monary)
  
  //@BeanProperty和private修饰不能同时使用
//  a.setMonary(300)
//  println(a.getMonary())
  
  
}