Feature: Buy two products randomly

  Scenario: User can buy two products randomly
    Given user logins as "standard_user"
    And add two products into the cart
    When user checks the cart
    Then numbers of cart shows
