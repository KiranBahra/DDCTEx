import scala.util.control.Breaks

object MenuItemsCalcs{

  val cola = MenuItems("Cola", 0.50, false,false)
  val coffee = MenuItems("Coffee", 1.00, false,true)
  val cheeseSandwich = MenuItems("Cheese Sandwich", 2.00, true,false)
  val steakSandwich = MenuItems("Steak Sandwich", 4.50, true,true)
  val total =List(cola,coffee,cheeseSandwich,steakSandwich)
  val items= List(cola,coffee,cheeseSandwich)
  val onlyDrinks =List(cola,coffee)
  val onlyFood =List(cheeseSandwich,steakSandwich)
  val onlyColdFood= List(cheeseSandwich)
  val onlyColdFoodDrink= List(cola,coffee,cheeseSandwich)
  val onlyHotFood = List(steakSandwich)
  val onlyHotFoodDrink = List(cola, coffee,steakSandwich)


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
  def CheckServiceCharge (serviceCharge :Double): Double={
    if (serviceCharge > 20.00 || serviceCharge == 20.00 ){
      println("service charge capped")
      return 20.00
    }else {
      println("service charge under 20 quid")
      return serviceCharge
    }
  }

  def CalculateServiceCharge (initialCost : Double, x:List[MenuItems]): Double = {
    var finalCost = 0.00
    var foodPresent = false
    var HotFoodPresent = false
    var drinksPresent = false
    var serviceCharge = 0.00

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
    loop.breakable {
      for (a <- x) {
        if (a.isHot && a.isFood) {
          HotFoodPresent = true
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

    if (foodPresent ==true  && drinksPresent==true && HotFoodPresent==false){
      serviceCharge= (initialCost *0.1)
      CheckServiceCharge(serviceCharge)
      finalCost= serviceCharge + initialCost
    //  println("The final cost is " + finalCost + " both food and drink")
      return finalCost
    }else if (foodPresent ==true  && drinksPresent==true && HotFoodPresent==true) {
      serviceCharge= initialCost *0.2
      CheckServiceCharge(serviceCharge)
      finalCost= (serviceCharge) + initialCost
    //  println("The final cost is " + finalCost + " both hot food and drink")
      return finalCost

    }
    else if(foodPresent==true && drinksPresent==false && HotFoodPresent==false){
      serviceCharge=initialCost *0.1
      CheckServiceCharge(serviceCharge)
      finalCost= (serviceCharge) + initialCost
    //  println("The final cost is " + finalCost + " only cold food")
      return finalCost
    }else if (foodPresent==true && drinksPresent==false && HotFoodPresent==true){
      serviceCharge=initialCost *0.2
      CheckServiceCharge(serviceCharge)
      finalCost= (serviceCharge) + initialCost
     // println("The final cost is " + finalCost + " only hot food")
      return finalCost
    }
    else if (foodPresent==false && drinksPresent==true){
      finalCost= initialCost
    //  println("The final cost is " + finalCost + " only drinks")
      return finalCost
    }else{
    //  print("initial cost is " + initialCost)
      return initialCost
    }
  }



}
