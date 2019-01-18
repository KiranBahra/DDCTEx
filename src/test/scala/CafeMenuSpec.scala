import org.scalatest.{Matchers, WordSpec}

class CafeMenuSpec extends WordSpec with Matchers {
//reading the first item name
  "Get Item name of MenuItems" should {

     "be called Cola" in {
       MenuItemsCalcs.getItemName(MenuItemsCalcs.cola) shouldBe ("Cola")
      MenuItemsCalcs.cola.item shouldBe("Cola")
     }
    "be called Coffee" in {
      MenuItemsCalcs.getItemName(MenuItemsCalcs.coffee) shouldBe ("Coffee")
     // coffee.item shouldBe("Coffee")
    }
    "be called Cheese Sandwich" in {
      MenuItemsCalcs.getItemName(MenuItemsCalcs.cheeseSandwich)shouldBe ("Cheese Sandwich")
      //MenuItemsCalcs.cheeseSandwich.item shouldBe("Cheese Sandwich")
    }
    "be called Steak Sandwich" in {
      MenuItemsCalcs.getItemName(MenuItemsCalcs.steakSandwich) shouldBe ("Steak Sandwich")
      MenuItemsCalcs.steakSandwich.item shouldBe("Steak Sandwich")
    }
   }

// retrieving the correct price for item
  " Price of Item" should{
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
   "Item is hot" should{
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

  "Item is a drink" should{
    "be true for Cola" in {
      MenuItemsCalcs.isItemDrink(MenuItemsCalcs.cola) shouldBe (true)
    }
    "be true for Coffee " in {
      MenuItemsCalcs.isItemDrink(MenuItemsCalcs.coffee) shouldBe (true)
    }
    "be false for Cheese Sandwich  " in {
      MenuItemsCalcs.isItemDrink(MenuItemsCalcs.cheeseSandwich) shouldBe (false)
    }
    "be false for Steak Sandwich" in {
      MenuItemsCalcs.isItemDrink(MenuItemsCalcs.steakSandwich) shouldBe (false)
    }
  }
  "The total of items" should {
    "cost £8" in {
      val total =List(MenuItemsCalcs.cola,MenuItemsCalcs.coffee,MenuItemsCalcs.cheeseSandwich,MenuItemsCalcs.steakSandwich)

      MenuItemsCalcs.totalCost(total) shouldBe (8.00)
    }

  }
  "the total of cola + coffee + cheese sandwich " should {
    "cost £3.50" in {
      val items= List(MenuItemsCalcs.cola,MenuItemsCalcs.coffee,MenuItemsCalcs.cheeseSandwich)
      MenuItemsCalcs.totalCost(items) shouldBe(3.50)
    }
  }



}

//cola should be cold done
//cola should be 50p done
//coffee shouid be hot done
//coffee should be £1 done
//cheese sandwich should be cold done
//cheese sandwhich should be £2 done
//steak sandwhich should be hot done
//steak sandwhich should be £4.50 done

//total bill of inputted menu iteems should give a total value
//cola + coffee + cheese sandwhich should give 3.5

// ***part 2
//if items are drinks there  should be no service charge
//if items contains any food, add a service charge of 10% to total bill
//if there is any hot food in list, there should be a service charge of 20% to total bill and a max service charge of £20
