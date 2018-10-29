package essentialscala

object Movies {

  case class Film(name: String, yearOfRelease: Int, imdbRating: Double)

  case class Director(firstName: String, lastName: String, yearOfBirth: Int, films: Seq[Film])

  val memento = Film("Memento", 2000, 8.5)
  val darkKnight = Film("Dark Knight", 2008, 9.0)
  val inception = Film("Inception", 2010, 8.8)
  val highPlainsDrifter = Film("High Plains Drifter", 1973, 7.7)
  val outlawJoseyWales = Film("The Outlaw Josey Wales", 1976, 7.9)
  val unforgiven = Film("Unforgiven", 1992, 8.3)
  val granTorino = Film("Gran Torino", 2008, 8.2)
  val invictus = Film("Invictus", 2009, 7.4)
  val predator = Film("Predator", 1987, 7.9)
  val dieHard = Film("Die Hard", 1988, 8.3)
  val huntForRedOctober = Film("The Hunt for Red October", 1990, 7.6)
  val thomasCrownAffair = Film("The Thomas Crown Affair", 1999, 6.8)
  val eastwood = Director("Clint", "Eastwood", 1930, Seq(highPlainsDrifter, outlawJoseyWales, unforgiven, granTorino, invictus))
  val mcTiernan = Director("John", "McTiernan", 1951, Seq(predator, dieHard, huntForRedOctober, thomasCrownAffair))
  val nolan = Director("Christopher", "Nolan", 1970, Seq(memento, darkKnight, inception))
  val someGuy = Director("Just", "Some Guy", 1990, Seq())
  val directors = Seq(eastwood, mcTiernan, nolan, someGuy)

  def moviesScore(numberOfFilms: Int): Seq[Director] = {
    directors.filter(director => director.films.size > numberOfFilms)
  }

  def allMovies(): Seq[String] = {
    directors.flatMap(dir => dir.films).map(film => film.name)
  }

  def allDirectors(): Seq[String] = {
    directors.map(dir => dir.firstName + " " + dir.lastName)
  }

  def bornBefore(year: Int): Option[Director] = {
    directors.find(director => director.yearOfBirth < year)
  }

  def bornAndMovies(year: Int, numberOfFilms: Int): Seq[Director] = {
    val byAge = directors.filter(director => director.yearOfBirth < year)
    val byMovies = directors.filter(director => director.films.size > numberOfFilms)
    byAge.filter(byMovies.contains)
  }

  def sortDirectors(ascending: Boolean = true): Seq[Director] = {
    if (ascending) {
      directors.sortWith(_.yearOfBirth < _.yearOfBirth)
    } else {
      directors.sortWith(_.yearOfBirth > _.yearOfBirth)
    }
  }

  def nolanMovies(): Seq[String] = {
    nolan.films.map(m => m.name)
  }

  def erliestMcTiernan(): Int = {
    mcTiernan.films.map(f => f.yearOfRelease).sortWith(_ < _).head
  }

  def earliestEastwood(): Int = {
    eastwood.films.foldLeft(Int.MaxValue)((current, film) => math.min(current, film.yearOfRelease))
  }

  def sortMoviesByRating(): Seq[Film] = {
    directors.flatMap(d => d.films).sortWith((f, s) => f.imdbRating > s.imdbRating)
  }

  def averageScore(): Double = {
    val films = directors.flatMap(d => d.films)

    films.foldLeft(0.0)((a, b) => a + b.imdbRating) / films.length
  }

  def movieByDirector(): Unit = {
    directors.foreach(director => {
      director.films.foreach(movie => {
        println(s"Tonight only! ${movie.name} by ${director.firstName}!")
      })
    })
  }

  def earliestMovie() = {
    directors.flatMap(director => director.films).sortWith((a,b) => a.yearOfRelease < b.yearOfRelease).head
  }
}
