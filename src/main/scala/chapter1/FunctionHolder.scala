package chapter1

object FunctionHolder extends App{
  def max(a: Int, b: Int):Int = {
    if(a>b) a else b
  }

  println(max(6, 3))
}
