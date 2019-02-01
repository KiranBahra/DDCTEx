import org.scalatest.{Matchers, WordSpec}

class MenuItemsSpec extends WordSpec with Matchers {
  //reading the first item name
  "Get Item name of MenuItems" should {

    "be called Cola" in {
      Cola.item shouldBe ("Cola")
    }
    "be called Coffee" in {
      Coffee.item shouldBe("Coffee")
    }
    "be called Cheese Sandwich" in {
      CheeseSandwich.item shouldBe("Cheese Sandwich")
    }
    "be called Steak Sandwich" in {
      SteakSandwich.item shouldBe ("Steak Sandwich")
    }
  }

  // retrieving the correct price for item
  " Price of Item" should {
    "Cola price should be 50p " in {
      Cola.price shouldBe (0.50)
    }
    "Coffee price should be £1 " in {
      Coffee.price shouldBe (1.00)
    }
    "Cheese Sandwich price should be £2 " in {
      CheeseSandwich.price shouldBe (2.00)
    }
    "Steak Sandwich price should be £4.50" in {
      SteakSandwich.price shouldBe (4.50)
    }
  }
  //
  "Item is hot" should {
    "be false for Cola" in {
      Cola.isHot shouldBe (false)
    }
    "be true for Coffee " in {
      Coffee.isHot shouldBe (true)
    }
    "be false for Cheese Sandwich  " in {
      CheeseSandwich.isHot shouldBe (false)
    }
    "be true for Steak Sandwich" in {
      SteakSandwich.isHot shouldBe (true)
    }
  }

  "Item is food" should {
    "be false for Cola" in {
      Cola.isFood shouldBe (false)
    }
    "be false for Coffee " in {
      Coffee.isFood shouldBe (false)
    }
    "be true for Cheese Sandwich  " in {
      CheeseSandwich.isFood shouldBe (true)
    }
    "be true for Steak Sandwich" in {
      SteakSandwich.isFood shouldBe (true)
    }
  }
}
