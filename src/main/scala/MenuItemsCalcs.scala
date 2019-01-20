import scala.util.control.Breaks

object MenuItemsCalcs{

  val cola = MenuItems("Cola", 0.50, false,false)
  val coffee = MenuItems("Coffee", 1.00, false,true)
  val cheeseSandwich = MenuItems("Cheese Sandwich", 2.00, true,false)
  val steakSandwich = MenuItems("Steak Sandwich", 4.50, true,true)
  val total =List(cola,coffee,cheeseSandwich,steakSandwich)
  val items= List(cola,coffee,cheeseSandwich)
  val onlyDrinks =List(cola,coffee)
  val onlyfood =List(cheeseSandwich,steakSandwich)

  //function that will return the name of the item
  //when you put in a value into this function it should return the name of it (item)
def getItemName(menuItems: MenuItems): String =
    return menuItems.item

def priceOfItem (menuItems: MenuItems): Double=
  return menuItems.price

def isItemHot(menuItems: MenuItems): Boolean=
  return menuItems.isHot

def isItemFood (menuItems: MenuItems): Boolean=
  return menuItems.isFood
  //function to calculate the total of the items when inputting them as a list

def totalCost( x: List[MenuItems]) : Double= {
  var cost: Double = 0.00
  for (a <- x) {
    cost = cost + a.price
  }
  return cost
}

  /**
    * Add support for a service charge :
    * When all purchased items are drinks no service charge is applied
    * When purchased items include any food apply a service charge of 10% to the total bill (rounded to 2 decimal places)
    * When purchased items include any hot food apply a service charge of 20% to the total bill with a maximum £20 service charge
    *
    * @param initialCost
    * @return
    */
  def CalculateServiceCharge (initialCost : Double, x:List[MenuItems]): Double = {
    var finalCost = 0.00
    var foodPresent = false
    var drinksPresent = false

    //checking for if food is present
    val loop = new Breaks
    loop.breakable {
      for (a <- x) {
        if (a.isFood == true) {
          foodPresent = true
          loop.break()
        }
      }
    }
    //checking if drinks are present
    loop.breakable {
      for (a <- x) {
        if (a.isFood == false) {
          drinksPresent = true
          loop.break()
        }
      }
    }
    if (foodPresent ==true && drinksPresent==true){
      finalCost= (initialCost *0.1) + initialCost
     // println("The final cost is " + finalCost + " both food and drink")
      return finalCost
    }else if(foodPresent==true && drinksPresent==false){
      finalCost= (initialCost *0.1) + initialCost
     // println("The final cost is " + finalCost + " only food")
      return finalCost
    }else if (foodPresent==false && drinksPresent==true){
      finalCost= initialCost
     // println("The final cost is " + finalCost + " only drinks")
      return finalCost
    }else{
    //  print("initial cost is " + initialCost)
      return initialCost
    }
  }

}
