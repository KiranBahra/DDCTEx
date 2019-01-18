

case class MenuItems(
                 item: String,
                 price: Double,
                 Hot: Boolean,
                 Drink: Boolean
               )


def getName (menuItems: MenuItems): String ={
  return menuItems.item

}


val cola = MenuItems("Cola", 0.50, true,true)
val coffee = MenuItems("Coffee", 1.00, true,true)
val cheeseSandwich = MenuItems("Cheese Sandwich", 2.00, true,true)
val steakSandwich = MenuItems("Steak Sandwich", 4.50, true,true)

val total =List(cola,coffee,cheeseSandwich,steakSandwich)
println(total)

var cost : Double =0.00

for (a  <- total){
  cost= cost + a.price
}
println("the total cost is "+ cost)

def total (x: List[MenuItems]): Nothing =
  return
