package scala基础语法.cn.cxrx

object Test21 extends App{
  /*判断if*/
  def judge(a:Int): Int ={
    if(a > 0){
      1
    }else if(a < 0){
      -1
    }else{
      0
    }
  }
  println(judge(3))

  def judge1(a:Int): Int ={
    if(a > 0){
      1
    }else if(a < 0){
      -1
    }
    0
  }
  println(judge1(3)) //会返回0，因为默认总是会返回最后一行

  /*也可以写return*/
  def judge2(a:Int): Int ={
    if(a > 0){
      return 1
    }else if(a < 0){
      return -1
    }else{
      return 0
    }
  }
  println(judge2(3))
}
