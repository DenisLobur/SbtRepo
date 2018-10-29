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

}
