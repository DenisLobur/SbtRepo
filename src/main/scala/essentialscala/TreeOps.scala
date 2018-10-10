package essentialscala

object TreeOps {

}

sealed trait PolyTree {
  def sum: Int

  def double: PolyTree
}

final case class PolyLeaf(elem: Int) extends PolyTree {
  def sum: Int = elem

  def double: PolyTree = PolyLeaf(elem * 2)

}

final case class PolyNode(left: PolyTree, right: PolyTree) extends PolyTree {
  override def sum: Int = left.sum + right.sum

  override def double: PolyTree = PolyNode(left.double, right.double)
}
