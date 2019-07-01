package cn.cxrx

/**
  * 继承
  * 当一个类extends另外一个类的时候，override的规则基本如下：
  * 子类中的方法要覆盖父类中的方法，必须写override（参见foo）
  * 子类中的属性val要覆盖父类中的属性，必须写override（参见nameVal）
  * 父类中的变量不可以覆盖（参见nameVar）
  */
abstract class Person{
  val id:Int = 2
  var name:String = "张三"
  def show:Int
}

class Student extends Person{
  override val id:Int = 1 //常量都能覆盖 必须加override才行，否则是不能覆盖已经赋值的常量的
  //override var name:String = "李四"//这句会运行时报错的，看继承的规则上面写的
  override val show: Int = {100}//父类无参的def函数 子类可以使用val或者def定义
}

object Test71 extends App{
  var c = new Student
  println(c.id)
  println(c.show)
}
