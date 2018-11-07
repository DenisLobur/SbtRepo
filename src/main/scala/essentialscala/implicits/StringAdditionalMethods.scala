package essentialscala.implicits

object StringAdditionalMethods {

  implicit class Vowels(str: String) {
    val vowels = Seq('a', 'e', 'i', 'o', 'y', 'u')
    val onlyO = 'o'

    def numberOfVowels: Int = {
      str.toList.count(vowels contains _)
    }

    def onlyONumber: Int = {
      str.toList.count(_ equals onlyO)
    }
  }

}
