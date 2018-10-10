package essentialscala

sealed trait Tree {

  def sum(tree: Tree): Int = {
    tree match {
      case Leaf(elem) => elem
      case Node(left, right) => sum(left) + sum(right)
    }
  }

  def double(tree: Tree): Tree = {
    tree match {
      case Leaf(elem) => Leaf(elem * 2)
      case Node(left, right) => Node(double(left), double(right))
    }
  }
}

final case class Node(left: Tree, right: Tree) extends Tree

final case class Leaf(elem: Int) extends Tree
