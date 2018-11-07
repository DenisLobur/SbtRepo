package essentialscala.implicits

object IntImplicits {

  implicit class IntAdditionalMethods(int: Int) {

    def yeah: Unit = {
      for {
        i <- 1 to int
      } yield println("Oh yeah!")
    }

    def yeah2: Unit = {
      times(_ => println("Oh yeah!"))
    }

    def times(a: Int => Unit): Unit = {
      for (i <- 0 until int) a(i)
    }
  }

}
