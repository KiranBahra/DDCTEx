

object MenuItemsCalcs{

  //function to calculate the total of the items when inputting them as a list

  def totalCost( x: List[MenuItems]) : Double= {
    val cost = (x.map(t=>t.price)).sum
    //TODO: rewrite using collection (List) functions/methods think map and sum
    return cost
  }

  def CheckServiceCharge (serviceCharge :Double): Double={
    if (serviceCharge > 20.00 || serviceCharge == 20.00 ){
      // println("service charge capped")
      return 20.00
    }else {
      //  println("service charge under 20 quid")
      return serviceCharge
    }
  }

  def CalculateServiceCharge (initialCost : Double, x:List[MenuItems]): Double = {
    val foodPresent = x.exists(t => t.isFood ==true)
    val HotFoodPresent = x.exists(t=> (t.isHot==true && t.isFood==true))
    val drinksPresent = x.exists((t=> t.isFood==false))

    if (foodPresent ==true  && drinksPresent==true && HotFoodPresent==false){
      val serviceCharge= (initialCost *0.1)
      CheckServiceCharge(serviceCharge)
       val finalCost= serviceCharge + initialCost
     // println("The final cost is " + finalCost + " both food and drink")
      return finalCost
    }else if (foodPresent ==true  && drinksPresent==true && HotFoodPresent==true) {
      val serviceCharge= initialCost *0.2
      CheckServiceCharge(serviceCharge)
      val finalCost= (serviceCharge) + initialCost
     // println("The final cost is " + finalCost + " both hot food and drink")
      return finalCost

    }
    else if(foodPresent==true && drinksPresent==false && HotFoodPresent==false){
      val serviceCharge=initialCost *0.1
      CheckServiceCharge(serviceCharge)
      val finalCost= (serviceCharge) + initialCost
     // println("The final cost is " + finalCost + " only cold food")
      return finalCost
    }else if (foodPresent==true && drinksPresent==false && HotFoodPresent==true){
      val serviceCharge=initialCost *0.2
      CheckServiceCharge(serviceCharge)
      val finalCost= (serviceCharge) + initialCost
     // println("The final cost is " + finalCost + " only hot food")
      return finalCost
    }
    else if (foodPresent==false && drinksPresent==true){
      val finalCost= initialCost
     // println("The final cost is " + finalCost + " only drinks")
      return finalCost
    }else{
      //print("initial cost is " + initialCost)
      return initialCost
    }
  }



}
