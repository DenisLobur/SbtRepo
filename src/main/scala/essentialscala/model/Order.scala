package essentialscala.model

final case class Orders(units: Int, unitPrice: Double) {
  val totalPrice: Double = units * unitPrice

  object OrderByTotalPrice {
    val ordering: Ordering[Orders] =
      Ordering.fromLessThan[Orders]((o1: Orders, o2: Orders) => o1.totalPrice > o2.totalPrice)
  }

  object OrderByUnits {
    val ordering: Ordering[Orders] =
      Ordering.fromLessThan[Orders]((o1: Orders, o2: Orders) => o1.units > o2.units)
  }

  object OrderByUnitPrice {
    val ordering: Ordering[Orders] =
      Ordering.fromLessThan[Orders]((o1: Orders, o2: Orders) => o1.unitPrice > o2.unitPrice)
  }
}
