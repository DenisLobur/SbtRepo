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
    seq.foreach{el => result = f(result, el)}
    result
  }

}
