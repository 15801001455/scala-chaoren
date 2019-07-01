package cn.cxrxy

/**
 * 控制结构
 */
object Test21 extends App{
  /*判断if*/
  //scala中return就相当于函数版
  def judge(a : Int) :Int = {
    if(a > 0){
       1
    }else if(a < 0){
      -1
    }else{
       0
    }
  }
  
  println(judge(3))
}