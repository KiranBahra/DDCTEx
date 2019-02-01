import org.scalatest.{Matchers, WordSpec}

class MenuItemsCalcsSpec extends WordSpec with Matchers {

  val total =List(Cola,Coffee,CheeseSandwich,SteakSandwich)
  val items= List(Cola,Coffee,CheeseSandwich)
  val onlyDrinks =List(Cola,Coffee)
  val onlyFood =List(CheeseSandwich,SteakSandwich)
  val onlyColdFood= List(CheeseSandwich)
  val onlyColdFoodDrink= List(Cola,Coffee,CheeseSandwich)
  val onlyHotFood = List(SteakSandwich)
  val onlyHotFoodDrink = List(Cola, Coffee,SteakSandwich)

  

  //testing the total cost for any item that is inputted
  "The total of items" should {
    "cost £8" in {
      MenuItemsCalcs.totalCost(total) shouldBe (8.00)
    }

  }
  "the total of cola + coffee + cheese sandwich " should {
    "cost £3.50" in {
      MenuItemsCalcs.totalCost(items) shouldBe (3.50)
    }
  }
  "the total of cola + coffee  " should {
    "cost £1.50" in {
      MenuItemsCalcs.totalCost(onlyDrinks) shouldBe (1.50)
    }
  }
  "the total of cheese sandwich + steak sandwich " should {
    "cost £6.50" in {
      MenuItemsCalcs.totalCost(onlyFood) shouldBe (6.50)
    }
  }


  //part 2 of exercise
//adding a service charge to the items in the menu based on their properties

  //service charge function tests
  "if the service charge is more than 20 pounds, there" should {
    "be a cap set, return the max of £20" in {
      MenuItemsCalcs.CheckServiceCharge(21.00) shouldBe (20.00)
    }
  }

  "if the service charge is equal to £20 there" should {
    "be a cap set of £20 for the service charge" in {
      MenuItemsCalcs.CheckServiceCharge(20.00) shouldBe(20.00)
    }
  }
  "if the service charge is less than £20 there" should {
    "be a returned value of the service charge" in{
      MenuItemsCalcs.CheckServiceCharge(19.00) shouldBe(19.00)
    }
  }
//calculating the service charge for specified items
  "if items only contain drinks there" should {
    "be no service charge when drinks are included in the list" in {
      MenuItemsCalcs.CalculateServiceCharge(MenuItemsCalcs.totalCost(onlyDrinks), onlyDrinks) shouldBe (1.50)
    }
  }
   "if items contain only hot food there"  should {
      "be a 20 % service charge added to the total cost where the service charge is under the cap limit of £20" in {
        MenuItemsCalcs.CalculateServiceCharge(MenuItemsCalcs.totalCost(onlyHotFood), onlyHotFood) shouldBe (5.40)
      }
    }
"if items contain only cold food there " should {
  "be a 10% service charge added to the total cost where the service charge is under the cap limit of £20" in{
    MenuItemsCalcs.CalculateServiceCharge(MenuItemsCalcs.totalCost(onlyColdFood), onlyColdFood) shouldBe (2.20)
  }
}
  "if items contain a combination of drinks and cold food there " should {
    "be a 10% service charge added to the total cost where the service charge is under the cap limit of £20" in {
      MenuItemsCalcs.CalculateServiceCharge(MenuItemsCalcs.totalCost(onlyColdFoodDrink), onlyColdFoodDrink) shouldBe (3.85)
    }
  }

  " if items contain a combination of drinks and hot food there" should {
    "be a 20% service charge added to the total cost where the service charge is under the cap limit of £20" in {
      MenuItemsCalcs.CalculateServiceCharge(MenuItemsCalcs.totalCost(onlyHotFoodDrink), onlyHotFoodDrink) shouldBe(7.20)
    }

  }

  "5 Colas" should {
    "cost £2.50" in {
      val total = MenuItemsCalcs.totalCost(List(Cola, Cola, Cola, Cola, Cola))
      total shouldBe 2.5
    }
  }








}

// ***part 2
//if imtems are drinks there  should be no service charge done
//if items contains any food, add a service charge of 10% to total bill done
//if there is any hot food in list, there should be a service charge of 20% to total bill and a max service charge of £20

/*
tests to write:


6.when it is higher than than £20 test

 */