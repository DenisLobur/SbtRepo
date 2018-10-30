package essentialscala

object CollectionsRunner extends App {
  val seq = Seq(1, 2, 3)
  println(seq)
  println(seq.apply(1))
  println(seq.headOption)
  println(seq.find(_ > 4))
  println(seq.sortWith(_ > _))
  println(0 +: seq :+ 4)
  println(seq ++ Seq(1, 2, 3))
  println(Nil)

  val list = List(1, 2, 3)
  println(List(4, 5, 6) ++ list)
  println(Vector(1, 2, 3).toList)

  val animals = Seq("cat", "dog", "penguin")
  val extendedAnimals = "mouse" +: animals :+ "tyrannosaurus"
  println(animals)
  println(extendedAnimals)
  println(2 +: animals)

  val movies = Movies
  val moreThenTwo = movies.moviesScore(2)
  val bornBefore = movies.bornBefore(1940)
  val moreThenTwoAndBornBefore = movies.bornAndMovies(1940, 3)
  println("more than: " + moreThenTwo)
  println("born before: " + bornBefore)
  println("born and movies: " + moreThenTwoAndBornBefore)
  println("all movies: " + movies.allMovies())
  println("all directors: " + movies.allDirectors())
  println("Nolan's movies: " + movies.nolanMovies())
  println("earliest McTiernen: " + movies.erliestMcTiernan())
  println("earliest Eastwood: " + movies.earliestEastwood())
  println("movies by rating: " + movies.sortMoviesByRating())
  println("average rating: " + movies.averageScore())
  movies.movieByDirector()
  println("earliest movie: " + movies.earliestMovie())

  val trySeq = Seq(12, 20, 3, 4, 5, 6, 57, 68, 78, 7)
  val seqOps = SeqOps
  println(seqOps.min(trySeq))

  val testSeq = Seq(1, 1, 2, 4, 3, 4)
  println("unique entries: " + seqOps.unique(testSeq))
  val testReverse = Seq(1, 2, 3, 4, 5, 6)
  println("reversed: " + seqOps.reverse(testReverse))
  println("mapped: " + seqOps.map(testReverse, (x: Int) => x * 3))
  println("foldedLeft: " + seqOps.foldLeft(testReverse)(0)((a, b) => a + b))
  val z = for {
    x <- Seq(1,2,3)
  } yield x * 2
  println(z)

  println("Nolan's movies using For: " + movies.nolanMoviesWithFor())
  println("All movies with For: " + movies.allMoviesWithFor())
  println("Movies by rating with For: " + movies.sortMoviesByRatingWithFor())
  movies.moviesByDirectorWithFor()

  println(seqOps.parseIntFromString("122a").getOrElse(0))
  val a = seqOps.parseIntFromString("12")
  val b = seqOps.parseIntFromString("3")
  println("Sum of two Options is equal to: " + seqOps.addOptions(a,b))
  println("Sum of two OptionsHOF is equal to: " + seqOps.addOptionsHOF(a,b))
  println("Sum of three Options is equal to: " + seqOps.addThreeOptions(a,b,a))
  println("Sum of three OptionsHOF is equal to: " + seqOps.addThreeOptionsHOF(a,b,a))
  println("Division with options: " + seqOps.divide(6,0))
  println("Division with options: " + seqOps.divideOptions(Some(4), Some(2)))

  val calculator = Calculator
  calculator.calculate("3", "*", "2")
  calculator.calculateHOF("3", "*", "2")

  println("Add three options: " + seqOps.addOptions(Some(1), Some(2), Some(3)))
}
