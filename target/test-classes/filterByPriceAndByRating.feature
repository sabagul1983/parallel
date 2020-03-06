@filter
Feature: Filter
  As an end user
  I want to apply filers
  So that i can find desired product

  @filterByPriceAndByRating
  Scenario Outline: Filter by review
    Given I am on homepage
    When I search for product "<searchTerm>"
    And I apply price review "<priceRange>"
    And I apply filter review "<filter>"
    Then I should be able to see products in price range
    Examples:
      |searchTerm  |priceRange   |filter  |
      |nike        |£10 - £15    |3or more|
      |puma        |£20 - £30    |2or more|