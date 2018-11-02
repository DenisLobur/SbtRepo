package essentialscala.model

final case class Rational(numerator: Int, denominator: Int) {

  private def lcm(a: Int, b: Int) = {
    def gcd(a: Int, b: Int): Int = if (a % b == 0) b else gcd(b, a % b)

    b / gcd(a, b) * a
  }

  def <(that: Rational): Boolean = {
    val commonDenom = lcm(this.denominator, that.denominator)
    val r1NewNumerator = commonDenom / this.denominator * this.numerator
    val r2NewNumerator = commonDenom / that.denominator * that.numerator
    r1NewNumerator < r2NewNumerator
  }

  def >(that: Rational): Boolean = {
    ! <(that)
  }

  override def toString: String = {
    numerator + "/" + denominator
  }


}
