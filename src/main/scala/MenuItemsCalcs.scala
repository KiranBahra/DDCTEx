
object MenuItemsCalcs{

  val cola = MenuItems("Cola", 0.50, true,false)
  val coffee = MenuItems("Coffee", 1.00, true,true)
  val cheeseSandwich = MenuItems("Cheese Sandwich", 2.00, false,false)
  val steakSandwich = MenuItems("Steak Sandwich", 4.50, false,true)
  //function that will return the name of the item
  //when you put in a value into this function it should return the name of it (item)
def getItemName(menuItems: MenuItems): String =
    return menuItems.item

def priceOfItem (menuItems: MenuItems): Double=
  return menuItems.price

def isItemHot(menuItems: MenuItems): Boolean=
  return menuItems.isHot

def isItemDrink (menuItems: MenuItems): Boolean=
  return menuItems.isDrink
  //function to calculate the total of the items when inputting them as a list

def totalCost( x: List[MenuItems]) : Double= {
  println(x)
  var cost: Double = 0.00
  for (a <- x) {
    cost = cost + a.price
  }
  return cost
}
/**
  val total =List(cola,coffee,cheeseSandwich,steakSandwich)
  val total = x
  println(x)

  var cost : Double =0.00

  for (a  <- total){
    cost= cost + a.price
  }
  println("the total cost is "+ cost)
*/
}
