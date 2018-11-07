package essentialscala

import essentialscala.model.Person

package object implicits {

  object NameAndEmailImplicit {
    implicit object NameAndEmailEqual extends Equal[Person] {
      def equal(fst: Person, snd: Person): Boolean = {
        fst.name == snd.name && fst.email == snd.email
      }
    }
  }

  object EmailImplicit {
    implicit object EmailEqual extends Equal[Person] {
      override def equal(entry1: Person, entry2: Person): Boolean = {
        entry1.email == entry2.email
      }
    }
  }
}
