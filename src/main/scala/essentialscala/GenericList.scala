package essentialscala

sealed trait GenericList[A] {
  def length: Int = {
    this match {
      case GenericEnd() => 0
      case GenericPair(head, tail) => 1 + tail.length
    }
  }

  def contains(elem: A): Boolean = {
    this match {
      case GenericEnd() => false
      case GenericPair(head, tail) => if (head == elem) true else tail.contains(elem)
    }
  }

  def apply(index: Int): A = {
    this match {
      case GenericEnd() => throw new Exception("Bad things happened")
      case GenericPair(head, tail) => if (index == 0) head else tail.apply(index - 1)
    }
  }
}

final case class GenericEnd[A]() extends GenericList[A]

final case class GenericPair[A](head: A, tail: GenericList[A]) extends GenericList[A]
