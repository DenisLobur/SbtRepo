package essentialscala

sealed trait GenericTree[A] {
  def fold[B](node: (B, B) => B, leaf: A => B): B
}

final case class GenericNode[A](left: GenericTree[A], right: GenericTree[A]) extends GenericTree[A] {
  override def fold[B](node: (B, B) => B, leaf: A => B): B = {
    node(left.fold(node, leaf), right.fold(node, leaf))
  }
}

final case class GenericLeaf[A](value: A) extends GenericTree[A] {
  override def fold[B](node: (B, B) => B, leaf: A => B): B = {
    leaf(value)
  }
}
