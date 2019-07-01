package cn.cxrx

/**
  * 类的定义 自定义getter和setter
  * 还有[this]左右
  */
class TestClass42{
  //private[this] var money:Int = 0 把这行打开 add方法会报错，思考一下
  private var money:Int = 0

  def setMoney(money:Int): Unit ={
    if(money >0){
      this.money = money
    }
  }
  def getMoney():Int = {
    this.money
  }

  //累加 这种写法java有吗
  def add(a:TestClass42): Unit ={
    this.money += a.money
  }
}

object Test42 extends App{
  var c = new TestClass42
  c.setMoney(100)
  println(c.getMoney())
  c.add(c)//累加
  println(c.getMoney())
}
