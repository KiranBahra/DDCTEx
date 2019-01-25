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
val onlyColdFoodDrink= List(cola,coffee,cheeseSandwich)
val onlyHotFood = List(steakSandwich)
val  onlyHotFoodDrink = List(cola, coffee,steakSandwich)

var cost : Double =0.00
/*
for (a  <- total){
  cost= cost + a.price
}
println("the total cost is "+ cost)
*/
//go through list to check if any food is available
//go through list to check if any drinks are available
//if food is false - means there is only drinks
//if drinks is false - means there is only food
//if both are true then it contains both where charge is also applied
def CalculateServiceCharge (initialCost : Double, x:List[MenuItems]): Double = {
  var finalCost = 0.00
  var foodPresent = false
  var HotFoodPresent = false
  var drinksPresent = false

  //checking for if food is present
  val loop = new Breaks
  loop.breakable {
    for (a <- x) {
      if (a.isFood == true) {
        foodPresent = true
        loop.break()
      }
    }}

  loop.breakable {
    for (a <- x) {
      if (a.isHot == true && a.isFood == true) {
        HotFoodPresent = true
        //println("hot food is present ")
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
    finalCost= (initialCost *0.1) + initialCost
     println("The final cost is " + finalCost + " both food and drink")
    return finalCost
  }else if (foodPresent ==true  && drinksPresent==true && HotFoodPresent==true) {
    finalCost= (initialCost *0.2) + initialCost
     println("The final cost is " + finalCost + " both hot food and drink")
    return finalCost

  }
  else if(foodPresent==true && drinksPresent==false && HotFoodPresent==false){
    finalCost= (initialCost *0.1) + initialCost
     println("The final cost is " + finalCost + " only cold food")
    return finalCost
  }else if (foodPresent==true && drinksPresent==false && HotFoodPresent==true){
    finalCost= (initialCost *0.2) + initialCost
    println("The final cost is " + finalCost + " only hot food")
    return finalCost
  }
  else if (foodPresent==false && drinksPresent==true){
    finalCost= initialCost
     println("The final cost is " + finalCost + " only drinks")
    return finalCost
  }else{
      print("initial cost is " + initialCost)
    return initialCost
  }
}

CalculateServiceCharge(6.50, onlyHotFood)

//if  ALL are drinks - no service charge
//if  food present in any then 10% charge