package scala基础语法.cn.exec

object TestObject02 extends App{
  def judge(i:Int):Int = {
    if(i > 0){
      Integer.MAX_VALUE
    }else{
      Integer.MAX_VALUE+1
    }
  }

  println(judge(1)) //2147483647
  println(judge(-1)) //-2147483648
}
