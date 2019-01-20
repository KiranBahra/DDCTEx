import scala.util.control.Breaks
case class MenuItems (
                       item:String,
                       price:Double,
                       isFood:Boolean,
                       isHot:Boolean
                     )

val cola = MenuItems("Cola", 0.50, false,false)
val coffee = MenuItems("Coffee", 1.00, false,true)
val cheeseSandwich = MenuItems("Cheese Sandwich", 2.00, true,false)
val steakSandwich = MenuItems("Steak Sandwich", 4.50, true,true)

val total =List(cola,coffee,cheeseSandwich,steakSandwich)
val onlyfood =List(cheeseSandwich,steakSandwich)
val onlyDrinks =List(cola,coffee)

def CalculateServiceCharge (initialCost : Double, x:List[MenuItems]): Unit = {
  var finalCost = 0.00

  var drinksPresent = false
  //checking for if food is present
  val loop = new Breaks
  loop.breakable {
    for (a <- x) {
      if (a.isFood == true) {
        val foodPresent = true
        println("food is present for sure")
        println(foodPresent)
        loop.break()
        }
    }
  }
}
CalculateServiceCharge(4.00, onlyfood)
