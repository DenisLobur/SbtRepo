package essentialscala

import essentialscala.model.Rational

object TypeClassRunner extends App {

  val lessThen = Ordering.fromLessThan[Int](_ < _)
  val greaterThen = Ordering.fromLessThan[Int](_ > _)
  val lessSortedList = List(2, 1, 5, 3).sorted(lessThen)
  val greaterSortedList = List(2, 1, 5, 3).sorted(greaterThen)
  println("lessThen sorted list: " + lessSortedList)
  println("greaterThen sorted list: " + greaterSortedList)

  implicit val absOrdering = Ordering.fromLessThan(math.abs(_: Int) < math.abs(_: Int))
  assert(List(-4, -1, 0, 2, 3).sorted == List(0, -1, 2, 3, -4))
  assert(List(-4, -3, -2, -1).sorted == List(-1, -2, -3, -4))

  implicit val rationalOrder = Ordering.fromLessThan[Rational]((a, b) => a > b)
//  assert(List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted ==
//    List(Rational(1, 3), Rational(1, 2), Rational(3, 4)))
  val sortRationals = List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted
  println("sorted rationals: " + sortRationals)
}


