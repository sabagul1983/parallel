@addToTrolley
Feature: Filter
  As an end user
  I want to apply filers and add items to my trolley
  So that i can buy desired product

  @addToTrolleyAfterFilter
  Scenario: Filter by review and add to trolley
    Given I am on homepage
    When I search for product "philips iron"
    And I apply filter review "3or more"
    And I add an item "Philips GC4532/26 Azur Steam Iron" to trolley
    Then I should be able to see product in trolley
