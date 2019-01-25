import org.scalatest.{Matchers, WordSpec}

class CafeMenuSpec extends WordSpec with Matchers {
  //reading the first item name
  "Get Item name of MenuItems" should {

    "be called Cola" in {
      MenuItemsCalcs.getItemName(MenuItemsCalcs.cola) shouldBe ("Cola")
      MenuItemsCalcs.cola.item shouldBe ("Cola")
    }
    "be called Coffee" in {
      MenuItemsCalcs.getItemName(MenuItemsCalcs.coffee) shouldBe ("Coffee")
      // coffee.item shouldBe("Coffee")
    }
    "be called Cheese Sandwich" in {
      MenuItemsCalcs.getItemName(MenuItemsCalcs.cheeseSandwich) shouldBe ("Cheese Sandwich")
      //MenuItemsCalcs.cheeseSandwich.item shouldBe("Cheese Sandwich")
    }
    "be called Steak Sandwich" in {
      MenuItemsCalcs.getItemName(MenuItemsCalcs.steakSandwich) shouldBe ("Steak Sandwich")
      MenuItemsCalcs.steakSandwich.item shouldBe ("Steak Sandwich")
    }
  }

  // retrieving the correct price for item
  " Price of Item" should {
    "Cola price should be 50p " in {
      MenuItemsCalcs.priceOfItem(MenuItemsCalcs.cola) shouldBe (0.50)
    }
    "Coffee price should be £1 " in {
      MenuItemsCalcs.priceOfItem(MenuItemsCalcs.coffee) shouldBe (1.00)
    }
    "Cheese Sandwich price should be £2 " in {
      MenuItemsCalcs.priceOfItem(MenuItemsCalcs.cheeseSandwich) shouldBe (2.00)
    }
    "Steak Sandwich price should be £4.50" in {
      MenuItemsCalcs.priceOfItem(MenuItemsCalcs.steakSandwich) shouldBe (4.50)
    }
  }
  //
  "Item is hot" should {
    "be false for Cola" in {
      MenuItemsCalcs.isItemHot(MenuItemsCalcs.cola) shouldBe (false)
    }
    "be true for Coffee " in {
      MenuItemsCalcs.isItemHot(MenuItemsCalcs.coffee) shouldBe (true)
    }
    "be false for Cheese Sandwich  " in {
      MenuItemsCalcs.isItemHot(MenuItemsCalcs.cheeseSandwich) shouldBe (false)
    }
    "be true for Steak Sandwich" in {
      MenuItemsCalcs.isItemHot(MenuItemsCalcs.steakSandwich) shouldBe (true)
    }
  }

  "Item is food" should {
    "be false for Cola" in {
      MenuItemsCalcs.isItemFood(MenuItemsCalcs.cola) shouldBe (false)
    }
    "be false for Coffee " in {
      MenuItemsCalcs.isItemFood(MenuItemsCalcs.coffee) shouldBe (false)
    }
    "be true for Cheese Sandwich  " in {
      MenuItemsCalcs.isItemFood(MenuItemsCalcs.cheeseSandwich) shouldBe (true)
    }
    "be true for Steak Sandwich" in {
      MenuItemsCalcs.isItemFood(MenuItemsCalcs.steakSandwich) shouldBe (true)
    }
  }
  //testing the total cost for any item that is inputted
  "The total of items" should {
    "cost £8" in {
      MenuItemsCalcs.totalCost(MenuItemsCalcs.total) shouldBe (8.00)
    }

  }
  "the total of cola + coffee + cheese sandwich " should {
    "cost £3.50" in {
      MenuItemsCalcs.totalCost(MenuItemsCalcs.items) shouldBe (3.50)
    }
  }
  "the total of cola + coffee  " should {
    "cost £1.50" in {
      MenuItemsCalcs.totalCost(MenuItemsCalcs.onlyDrinks) shouldBe (1.50)
    }
  }
  "the total of cheese sandwich + steak sandwich " should {
    "cost £6.50" in {
      MenuItemsCalcs.totalCost(MenuItemsCalcs.onlyFood) shouldBe (6.50)
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
      MenuItemsCalcs.CalculateServiceCharge(MenuItemsCalcs.totalCost(MenuItemsCalcs.onlyDrinks), MenuItemsCalcs.onlyDrinks) shouldBe (1.50)
    }
  }
    "if items contain only hot food there"  should {
      "be a 20 % service charge added to the total cost where the service charge is under the cap limit of £20" in {
        MenuItemsCalcs.CalculateServiceCharge(MenuItemsCalcs.totalCost(MenuItemsCalcs.onlyHotFood), MenuItemsCalcs.onlyHotFood) shouldBe (5.40)
      }
    }
"if items contain only cold food there " should {
  "be a 10% service charge added to the total cost where the service charge is under the cap limit of £20" in{
    MenuItemsCalcs.CalculateServiceCharge(MenuItemsCalcs.totalCost(MenuItemsCalcs.onlyColdFood), MenuItemsCalcs.onlyColdFood) shouldBe (2.20)
  }
}
  "if items contain a combination of drinks and cold food there " should {
    "be a 10% service charge added to the total cost where the service charge is under the cap limit of £20" in {
      MenuItemsCalcs.CalculateServiceCharge(MenuItemsCalcs.totalCost(MenuItemsCalcs.onlyColdFoodDrink), MenuItemsCalcs.onlyColdFoodDrink) shouldBe (3.85)
    }
  }

  " if items contain a combination of drinks and hot food there" should {
    "be a 20% service charge added to the total cost where the service charge is under the cap limit of £20" in {
      MenuItemsCalcs.CalculateServiceCharge(MenuItemsCalcs.totalCost(MenuItemsCalcs.onlyHotFoodDrink), MenuItemsCalcs.onlyHotFoodDrink) shouldBe(7.20)
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