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

  assert(genericExample.contains(3) == true)
  assert(genericExample.contains(4) == false)
  assert(GenericEnd().contains(0) == false)

  assert(genericExample(0) == 1)
  assert(genericExample(1) == 2)
  assert(genericExample(2) == 3)
  assert(try {
    genericExample(3)
    false
  } catch {
    case e: Exception => true
  })

  val abstractExample = Pair(1, Pair(2, Pair(3, Pair(4, End))))

  println("abstract sum: " + abstractExample.abstraction(0, (head, tail) => head + tail))
  println("abstract product: " + abstractExample.abstraction(1, (head, tail) => head * tail))
  println("abstract length: " + abstractExample.abstraction(0, (_, tail) => 1 + tail))

  val foldExample = PairFold(1, PairFold(2, PairFold(3, PairFold(4, EndFold))))

  println("fold length: " + foldExample.length())
  println("fold sum: " + foldExample.sum())
  println("fold product: " + foldExample.product())
  println("fold double: " + foldExample.double())

  val tree: GenericTree[String] =
    GenericNode(GenericNode(GenericLeaf("To"), GenericLeaf("iterate")),
      GenericNode(GenericNode(GenericLeaf("is"), GenericLeaf("human,")),
        GenericNode(GenericLeaf("to"), GenericNode(GenericLeaf("recurse"),
          GenericLeaf("divine")))))

  println(tree.fold[String]((a, b) => a + " " + b, str => str))

  val pair = MyGenericPair[String, Int]("hi", 42)
  println("pair first: " + pair.first)
  println("pair second: " + pair.second)

  val left = Left[Int, String](1).value
  println("left value: " + left)

  val right = Right[Int, String]("foo").value
  println("right value: " + right)

  def intOrString(input: Boolean): Sum[Int, String] =
    if(input == true) {
      Left[Int, String](123)
    } else {
      Right[Int, String]("abc")
    }

  println("intOrString: " + intOrString(true))

  val sum: Sum[Int, String] = Right("foo")

  val checkSum = sum match {
    case Left(value) => value.toString
    case Right(value) => value
  }

  println("check sum: " + checkSum)

  val checkFoldSum = Left(123)
  val checkSumVal = checkFoldSum.fold[String](a => a.toString, int => int)
  println("checkSumValue: " +  checkSumVal.isInstanceOf[Double] )


  val perhaps: Maybe[Int] = Empty[Int]
  val perhaps2: Maybe[Int] = Full(1)

  println("maybe: " + perhaps + " " + perhaps2)
}

