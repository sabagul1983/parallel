@filter
Feature: Filter
  As an end user
  I want to apply filers
  So that i can find desired product

@filterByCustomerRating
Scenario Outline: Filter by review with examples
  Given I am on homepage
  When I search for product "<searchTerm>"
  And I apply filter review "<filter>"
  Then I should be able to see product rating "<rating>"
  Examples:
  | searchTerm |filter  |rating|
  |puma        |3or more|3     |
  |nike        |4or more|4     |