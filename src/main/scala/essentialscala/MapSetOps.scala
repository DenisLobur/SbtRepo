package essentialscala

import scala.collection.immutable.Set.Set2

object MapSetOps {

  private val people = Set(
    "Alice",
    "Bob",
    "Charlie",
    "Derek",
    "Edith",
    "Fred"
  )

  private val ages = Map(
    "Alice" -> 20,
    "Bob" -> 30,
    "Charlie" -> 50,
    "Derek" -> 40,
    "Edith" -> 10,
    "Fred" -> 60
  )

  private val favoriteColors = Map(
    "Bob" -> "green",
    "Derek" -> "magenta",
    "Fred" -> "yellow"
  )

  val favoriteLolcats = Map(
    "Alice" -> "Long Cat",
    "Charlie" -> "Ceiling Cat",
    "Edith" -> "Cloud Cat"
  )

  def favoriteColor(name: String): String = {
    favoriteColors.getOrElse(name, "beige")
  }

  def printColors(): Unit = {
    people.foreach(name => println(s"${name}'s favorite color is: " + favoriteColor(name)))
  }

  def lookup[A](name: String, values: Map[String, A]) = {
    values get name
  }

  def getOldestColor() = {
    val oldest = ages.foldLeft(Option.empty[String]) { (personsName, person) =>
      if (ages.getOrElse(person._1, 0) > personsName.flatMap(name => ages.get(name)).getOrElse(0)) {
        Some(person._1)
      } else {
        personsName
      }
    }

    println("Oldest person's color: " + favoriteColor(oldest.get))
  }

  def union[A](set1: Set[A], set2: Set[A]): Set[A] = {
    set1.union(set2)
  }

  def unionMine[A](set1: Set[A], set2: Set[A]): Set[A] = {
    set1.foldLeft(set2)((set, el) => set + el)
    //    set1.flatMap(a => set2 + a)
    //    set1.map(a=>set2.map(b => set2+b))
  }

  //TODO: finish
  def unionOfMaps[A](map1: Map[A, Int], map2: Map[A, Int]): Map[A, Int] = {
    map1.foldLeft(map2) { (map, elt) =>
      val (k, v) = elt
      val newV = map.getOrElse(k, v)
      map + (k -> newV)
    }
  }

  //TODO: finish
  def unionOfGenMaps[A, B](map1: Map[A, B], map2: Map[A, B], add: (B, B) => B): Map[A, B] = {
    map1.foldLeft(map2) { (map, elt) =>
      val (k, v) = elt
      val newV = map.get(k).map(v2 => add(v, v2)).getOrElse(v)
      map + (k -> newV)
    }
  }
}
