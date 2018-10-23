package essentialscala

sealed trait Maybe[+A] {
  def fold[B](empty: B, full: A => B): B = {
    this match {
      case Empty => empty
      case Full(value) => full(value)
    }
  }

  def map[B](f: A => B): Maybe[B] = {
    this match {
      case Empty => Empty
      case Full(value) => Full(f(value))
    }
  }

  def mapFlatMap[B](f: A => B): Maybe[B] = {
    flatMap[B](v => Full(f(v)))
  }

  def flatMap[B](f: A => Maybe[B]): Maybe[B] = {
    this match {
      case Empty => Empty
      case Full(value) => f(value)
    }
  }
}

final case class Full[A](value: A) extends Maybe[A]

final case object Empty extends Maybe[Nothing]
