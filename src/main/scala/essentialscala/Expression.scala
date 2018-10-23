package essentialscala

sealed trait Expression {
  def eval: Sum[String, Double] = {
    this match {
      case Addition(left, right) => operator(left, right, (l, r) => Success(l + r))
      case Subtraction(left, right) => operator(left, right, (l, r) => Success(l - r))
      case Division(left, right) => operator(left, right, (l, r) =>
        if (r == 0) {
          Failure("Division by zero")
        } else {
          Success(l / r)
        })
      case SquareRoot(value) =>
        value.eval flatMap { v =>
          if (v < 0) {
            Failure("Square root of negative number")
          } else {
            Success(Math.sqrt(v))
          }
        }
      case Number(value) => Success(value)
    }
  }

  def operator(left: Expression, right: Expression, f: (Double, Double) => Sum[String, Double]) = {
    left.eval flatMap { l =>
      right.eval flatMap { r =>
        f(l, r)
      }
    }
  }
}

final case class Addition(left: Expression, right: Expression) extends Expression

final case class Subtraction(left: Expression, right: Expression) extends Expression

final case class Division(left: Expression, right: Expression) extends Expression

final case class SquareRoot(value: Expression) extends Expression

final case class Number(value: Int) extends Expression