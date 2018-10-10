package essentialscala

object EssentialRunner extends App {
  val d = End
  val c = Pair(3, d)
  val b = Pair(2, c)
  val a = Pair(1, b)

  assert(sum(a) == 6)

  def sum(list: IntList): Int = {
    list match {
      case End => 0
      case Pair(head, tail) => head + sum(tail)
    }
  }

  val example = Pair(1, Pair(2, Pair(3, End)))

  assert(example.length == 3)
  assert(example.tail.length == 2)
  assert(End.length == 0)

  assert(example.product == 6)
  assert(example.tail.product == 6)
  assert(End.product == 1)

  assert(example.double == Pair(2, Pair(4, Pair(6, End))))
  assert(example.tail.double == Pair(4, Pair(6, End)))
  assert(End.double == End)

  val genericExample = GenericPair(1, GenericPair(2, GenericPair(3, GenericEnd())))

  assert(genericExample.length == 3)
  assert(genericExample.tail.length == 2)
  assert(GenericEnd().length == 0)



}
