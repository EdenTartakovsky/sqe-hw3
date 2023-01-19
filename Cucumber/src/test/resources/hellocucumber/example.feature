Feature: buying-delete-product
  Scenario: Test admin tries to delete a product from the list of products
    Given an admin is in adminPage and goes to product list
    And admin choose a product to delete
    And admin clicks on delete button
    Then product is deleted from the list of products

  Scenario: Test a non registered customer tries to buy a product
    Given A customer user is on home page
    When User navigates to cameras page
    And User selects a product
    And User adds product to cart
    And User navigates to checkout
    And User selects guest
    And enter first name
    And enter last name
    And enter email
    And enter address
    And enter city
    And enter country
    And enter region
    And click Continue
    And User enters shipping Method
    And User enters payment Method
    And user confirms order
#    Then Message displayed that the order has been placed successfully

    Scenario: Test a unregistered customer tries to buy a product and admin delete it
      Given A customer user is on home page
      When User navigates to cameras page
      And User selects a product
      And User adds product to cart
      And User navigates to checkout
      And User selects guest
      And enter first name
      And enter last name
      And an admin is in adminPage and goes to product list
      And admin choose a product to delete
      And admin clicks on delete button
      And enter email
      And click Continue
      And user confirms order
      Then Message displayed that the order has been placed successfully