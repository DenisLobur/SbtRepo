package essentialscala

import essentialscala.model.Person

trait Equal[A] {
  def equal(entry1: A, entry2: A): Boolean
}

object EmailEqualizer extends Equal[Person] {
  def equal(person1: Person, person2: Person): Boolean = {
    person1.email == person2.email
  }
}

object EmailAndNameEqualizer extends Equal[Person] {
  def equal(person1: Person, person2: Person): Boolean = {
    person1.email == person2.email && person1.name == person2.name
  }
}

object Equal {
  def apply[A](implicit instance: Equal[A]): Equal[A] = {
    instance
  }

  implicit class ToEqual[A](in: A) {
    def ===(other: A)(implicit equal: Equal[A]): Boolean = {
      equal.equal(in, other)
    }
  }
}

object Eq {
  def apply[A](fst: A, snd: A)(implicit equal: Equal[A]): Boolean = {
    equal.equal(fst, snd)
  }
}

object Eq2 {
  def apply[A](implicit instance: Equal[A]): Equal[A] = {
    instance
  }
}

