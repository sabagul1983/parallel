@addToTrolley
Feature: Filter
  As an end user
  I want to apply filers and add items to my trolley
  So that i can buy desired product

  @addToTrolleyBookItem
  Scenario: Filter by review and add to trolley
    Given I am on homepage
    When I search for product "puma"
    And I apply filter review "3or more"
    And I add an item to trolley
    Then I should be able to see product in trolley
    And I should be able to change quantity to "2"
    And I should be able to see total price
    And I should be able to see total price in trolley
    And I should be able to enter postocode"E7 8NW" in search
    And I select a store of my choice
    And I continue with collection

