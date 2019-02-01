class MenuItems (
                     val item:String,
                     val price:Double,
                     val isFood:Boolean,
                     val isHot:Boolean
                     )

case object Cola extends MenuItems("Cola", 0.50, false,false)
case object Coffee extends MenuItems("Coffee", 1.00, false,true)
case object CheeseSandwich extends MenuItems("Cheese Sandwich", 2.00, true,false)
case object SteakSandwich extends MenuItems("Steak Sandwich", 4.50, true,true)

