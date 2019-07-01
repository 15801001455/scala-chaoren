package cn.cxrxy

/**
 * 继承
 */

abstract class Person {  //抽象类可以有抽象的方法和字段，也可以有非抽象的方法和字段
  val id:Int 
  var name:String 
  def show:Int = {1}
}

//class Person {
//  val id:Int = 1
//  var name:String = ""
//  def show:Int = 1
//}

//继承一个抽象类的时候 不需要写override
class Student extends Person{
  override val id:Int = 2    //val使用val覆盖
  override var name:String = "Jackson"  //抽象的var只能使用var覆盖 
  override val show = 2    //无参的def可以使用val 或def
}

object Test71 extends App{
  var c = new Student
  println(c.id)
  println(c.show)
}