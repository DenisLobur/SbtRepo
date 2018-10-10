package easy

object SortArrayByParity {
  def sortArrayByParity(a: Array[Int]): Array[Int] = {
    def isEven(entry: Int) = entry % 2 == 0
    def isOdd(entry: Int) = !isEven(entry)

    val even: Array[Int] = a.filter(isEven)
    val odd: Array[Int] = a.filter(isOdd)
    even ++ odd
  }
}
