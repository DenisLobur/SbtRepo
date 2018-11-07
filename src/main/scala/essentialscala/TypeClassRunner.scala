package essentialscala

import essentialscala.model.{Person, Rational}

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

  val person1 = Person("John", "allen@gmail.com")
  val person2 = Person("Allen", "allen@gmail.com")

  println("Are emails equal: " + EmailEqualizer.equal(person1, person2))

  //implicit val emailEqualizer = EmailEqualizer
  //println("Are emails equal: " + Eq(Person("Noel", "noel@example.com"), Person("Noel", "noel@example.com")))

  def eqByNameAndEmail(person1: Person, person2: Person): Boolean = {
    import implicits.NameAndEmailImplicit._
    Eq(person1, person2)
  }

  def eqByEmail(person1: Person, person2: Person): Boolean = {
    import implicits.EmailImplicit._
    Eq(person1, person2)
  }

  def eqByCompanionObject(person1: Person, person2: Person): Boolean = {
    implicit val emailEqualizer = EmailEqualizer
    Eq2[Person].equal(person1,person2)
  }

  println("Equal using implicit objects: " + eqByNameAndEmail(person1, person2))
  println("Equal using implicit objects 2: " + eqByEmail(person1, person2))
  println("Equal using implicit companion object: " + eqByCompanionObject(person1, person2))

  import essentialscala.implicits.StringAdditionalMethods._
  println("Vowels count in 'quick brown fox' " + "quick brown fox".numberOfVowels)
  println("'O' count in 'quick brown fox' " + "quick brown fox".onlyONumber)

  import essentialscala.implicits.IntImplicits._
  2.yeah
  3.times(i => println(s"Look! There is number ${i}!"))
  3.yeah2

  implicit val caseInsensitiveEquals = new Equal[String] {
    def equal(s1: String, s2: String) =
      s1.toLowerCase == s2.toLowerCase
  }

  import Equal._
  println("equal using '===' " + "foo".===("FOb"))
}


