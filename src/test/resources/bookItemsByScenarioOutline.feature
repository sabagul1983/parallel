@addToTrolley
Feature: Filter
  As an end user
  I want to apply filers and add items to my trolley
  So that i can buy desired product

  @addToTrolleyBookItemScenarioOutline
  Scenario Outline: Filter by review and add to trolley
    Given I am on homepage
    When I search for product "<product>"
    And I apply filter review "<rating>"
    And I add an item to trolley
    Then I should be able to see product in trolley
    And I should be able to change quantity to "<quantity>"
    And I should be able to see total price
    And I should be able to see total price in trolley
    And I should be able to enter postocode"<postcode>" in search
    And I select a store of my choice
    And I continue with collection
    Examples:
      |product  |rating|quantity|postcode|
      |nike  |4or more|3|IG11 6AU|
      |puma  |3or more|2|E7 8NW|