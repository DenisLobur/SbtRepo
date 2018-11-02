package essentialscala

import essentialscala.model.Person

sealed trait Equal[A] {
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

