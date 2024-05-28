Feature: Products add to cart flow

  Scenario Outline: Add product to cart, remove and verify cart is empty
    Given user selected the car "<make>","<model>","<engine>"
    And user opened the wheels and tyres category
    And user picked the first offer from the list
    And user added 4 products to the cart
    And user navigated to the cart
    And cart contains correct products


    Examples:
      | make | model              | engine                  |
      | Audi | A3 (8P1) 2003-2012 | 1.6 FSI (BLP, BLF, BAG) |
      | BMW  | 3 (E46) 1997-2005  | 318 d (M47 D20 (204D1)) |
