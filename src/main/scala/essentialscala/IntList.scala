package essentialscala

sealed trait IntList {
  def length: Int = {
    this match {
      case End => 0
      case Pair(head, tail) => 1 + tail.length
    }
  }

  def product: Int = {
    this match {
      case End => 1
      case Pair(head, tail) => head * tail.product
    }
  }

  def double: IntList = {
    this match {
      case End => End
      case Pair(head, tail) => Pair(head * 2, tail.double)
    }
  }
}

final case object End extends IntList

final case class Pair(head: Int, tail: IntList) extends IntList