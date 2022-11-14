Feature: Login by user and add items to cart

  In order to buy some items
  As a potential buyer
  I want to be able to open card and add it to the basket

  Scenario: Should login, list items and add them to cart
    Given I want to login user with username = "standard_user" and password = "secret_sauce"
    Then I want to change sorting from a-Z to Z-a
    Then I want to open bottom left card details
    When Nothing added to shopping cart, its empty
    When I added item to the shopping cart
    Then Text inside card changed from “Add to cart” to “Remove”
    And Shopping cart image change to +1
