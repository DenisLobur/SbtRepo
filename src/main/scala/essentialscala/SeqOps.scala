package essentialscala

object SeqOps {

  def min(seq: Seq[Int]): Int = {
    seq.foldLeft(Int.MaxValue)((current, next) => math.min(current, next))
  }

  def unique(seq: Seq[Int]): Seq[Int] = {
    def insert(seq: Seq[Int], elm: Int) = {
      if (seq.contains(elm)) {
        seq
      } else {
        elm +: seq
      }
    }

    seq.foldLeft(Seq.empty[Int]) {
      insert
    }
  }

  def reverse[A](seq: Seq[A]): Seq[A] = {
    seq.foldLeft(Seq.empty[A])((sq, el) => el +: sq)
  }

  def map[A, B](seq: Seq[A], f: A => B): Seq[B] = {
    seq.foldRight(Seq.empty[B]) { (el, sq) => f(el) +: sq }
  }

  def foldLeft[A, B](seq: Seq[A])(zero: B)(f: (B, A) => B): B = {
    var result: B = zero
    seq.foreach { el => result = f(result, el) }
    result
  }

  def parseIntFromString(s: String): Option[Int] = {
    if (s matches "\\d+") Some(s.toInt) else None
  }

  def addOptions(a: Option[Int], b: Option[Int]): Option[Int] = {
    for {
      x <- a
      y <- b
    } yield x + y
  }

  def addThreeOptions(a: Option[Int], b: Option[Int], c: Option[Int]): Option[Int] = {
    for {
      x <- a
      y <- b
      z <- c
    } yield x + y + z
  }

  def addOptionsHOF(a: Option[Int], b: Option[Int]): Option[Int] = {
    a.flatMap(x => b.map(y => x + y))
  }

  def addThreeOptionsHOF(a: Option[Int], b: Option[Int], c: Option[Int]): Option[Int] = {
    a.flatMap { x =>
      b.flatMap { y =>
        c.map {
          z => x + y + z
        }
      }
    }
  }

  def divide(a: Int, b: Int): Option[Int] = {
    if (b == 0) {
      None
    } else {
      Some(a / b)
    }
  }

  def divideOptions(a: Option[Int], b: Option[Int]): Option[Int] = {
    for {
      x <- a
      y <- b
      z <- divide(x, y)
    } yield z
  }

  def addOptions(a: Option[Int], b: Option[Int], c: Option[Int]): Option[Int] = {
    a.flatMap { op1 => b.flatMap(op2 => c.map(op3 => op1 + op2 + op3))
    }
  }
}
