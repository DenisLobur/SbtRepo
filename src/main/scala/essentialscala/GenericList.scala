package essentialscala

sealed trait GenericList[A] {
  def length: Int = {
    this match {
      case GenericEnd() => 0
      case GenericPair(head, tail) => 1 + tail.length
    }
  }

  //TODO: implement
  def contains[A](elem: A): Boolean = {
    this match {
      case GenericEnd() => false
      case GenericPair(head, tail) => ???
    }
  }
}

final case class GenericEnd[A]() extends GenericList[A]

final case class GenericPair[A](head: A, tail: GenericList[A]) extends GenericList[A]
