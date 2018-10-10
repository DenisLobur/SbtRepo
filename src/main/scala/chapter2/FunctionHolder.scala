package chapter2

object FunctionHolder extends App {
  // Define simple function
  def max(a: Int, b: Int): Int = {
    if (a > b) a else b
  }

  println(max(6, 3))

  // Iterate with while loop
  val arg: Array[String] = new Array[String](3) // Init array of Strings with 3 empty elements
  arg(0) = "First"
  arg(1) = "Second"
  arg(2) = "Third"

  def iterateWithWhile(array: Array[String]): Unit = {
    var i = 0
    while (i < arg.length) {
      println(arg(i))
      i += 1
    }
  }

  iterateWithWhile(arg)

  // Iterate with foreach and for
  arg.foreach(ar => println(ar)) //1

  arg.foreach(println) //2

  for (ar <- arg) //3
    println(ar)

  for (ar <- 0 to 2) //4
    println(arg(ar))

  for (ar <- 0.to(2)) //5
    println(arg(ar))
}
