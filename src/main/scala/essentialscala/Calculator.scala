package essentialscala

object Calculator {
  private def parseString(str: String): Option[Int] = {
    if (str matches "\\d+") Some(str.toInt) else None
  }

  def calculate(operand1: String, operator: String, operand2: String): Unit = {
    val result = for {
      a <- parseString(operand1)
      b <- parseString(operand2)
      ans <- operator match {
        case "+" => Some(a + b)
        case "-" => Some(a - b)
        case "/" => if (b != 0) Some(a / b) else None
        case "*" => Some(a * b)
        case _ => None
      }
    } yield ans

    result match {
      case Some(value) => println(s"The answer is: " + value)
      case None => println(s"Error in calculating ${operand1} ${operator} ${operand2}")
    }
  }

  def calculateHOF(operand1: String, operator: String, operand2: String): Unit = {
    def calculateInternal(a: Int, b: Int) = {
      operator match {
        case "+" => Some(a + b)
        case "-" => Some(a - b)
        case "/" => if (b != 0) Some(a / b) else None
        case "*" => Some(a * b)
        case _ => None
      }
    }

    val result = parseString(operand1) flatMap { x => {
      parseString(operand2) flatMap { y => {
        calculateInternal(x, y) map { res =>
          res
        }
      }
      }
    }
    }

    result match {
      case Some(value) => println(s"The answer is: " + value)
      case None => println(s"Error in calculating ${operand1} ${operator} ${operand2}")
    }
  }
}
