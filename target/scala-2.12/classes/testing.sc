

case class Item(
                 item: String,
                 price: Double,
                 temp: Option[String],
                 foodType: Option[String])

val menu = Map(
  1-> Item("Cola",0.5,Some("Cold"), Some("Drink")),
  2 -> Item("Coffee", 1.00 ,Some("Hot"), Some("Drink")),
  3 -> Item("Cheese Sandwich", 2.00, Some("Cold"), Some("Food")),
  4 -> Item("Steak Sandwich", 4.50, Some("Cold"), Some("Food"))

)

