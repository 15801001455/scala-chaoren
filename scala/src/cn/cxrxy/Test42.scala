package cn.cxrxy

/**
 * 类的基本内容2
 */

class TestClass42{
//  private[this] var monary = 100
  private var monary = 100
  
  def setMonary(monary:Int){ //自定义setter方法
    if(monary > 0 )
    this.monary = monary
  }
  
  def getMonary = {  //自定义getter方法
    this.monary
  }
  
  def add(a:TestClass42){  //累加
    this.monary += a.monary
  }
}

//class TestClass42_1{
//  var monary = 100
//  def add(a: TestClass42) { //累加
//    this.monary += a.m
//  }
//}

object Test42 extends App{
  var c = new TestClass42
  c setMonary 100 
  println(c getMonary)
  
}