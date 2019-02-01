

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


val ItemPrice = total.map(p=>p.price)
val totalCost = ItemPrice.sum
//check if food is present
//val foodPresent= total.filter(t=> (t.isFood ==true && t.isHot ==true))
//val fowodPresent= onlyColdFoodDrink.exists(t=> (t.isFood ==true && t.isHot ==true))

val foodPresent = onlyColdFoodDrink.exists(t => t.isFood ==true)
val HotFoodPresent = onlyColdFoodDrink.exists(t=> t.isHot==true)
val drinksPresent = onlyColdFoodDrink.exists((t=> t.isFood==false))

