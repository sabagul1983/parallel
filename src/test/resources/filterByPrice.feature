@filter
Feature: Filter
  As an end user
  I want to apply filers
  So that i can find desired product

  @filterByPrice
  Scenario Outline: Filter by review
    Given I am on homepage
    When I search for product "<searchTerm>"
    And I apply price review "<priceRange>"
    Then I should be able to see products in price range
    Examples:
      |searchTerm  |priceRange   |
      |nike        |£10 - £15    |
      |puma        |£20 - £25    |
      |adidas      |£10 - £15    |