package essentialscala.model

case class User(val id: Long, val orders: List[Order])

case class Order(orderNumber: Int)
