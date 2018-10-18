package essentialscala

sealed trait IntGenericFoldList {

  def fold[A](end: A, f: (Int, A) => A): A = {
    this match {
      case EndFold => end
      case PairFold(head, tail) => f(head, tail.fold(end, f))
    }
  }

  def length(): Int = {
    fold[Int](0, (_, tail) => 1 + tail)
  }

  def sum(): Int = {
    fold[Int](0, (head, tail) => head + tail)
  }

  def product(): Int = {
    fold[Int](1, (head, tail) => head * tail)
  }

  def double(): IntGenericFoldList = {
    fold[IntGenericFoldList](EndFold, (head, tail) => PairFold(head * 2, tail))
  }
}

final object EndFold extends IntGenericFoldList

final case class PairFold(head: Int, tail: IntGenericFoldList) extends IntGenericFoldList
