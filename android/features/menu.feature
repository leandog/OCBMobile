Feature: Viewing Ohio City Burrito's Menu

  As a hungry burrito lover
  I want to see Ohio City Burrito's menu
  So that I can order a burrito!


  Scenario: Section headers
    Given I want to see what Ohio City Burrito serves
    When I touch the menu sign
    Then I should see "Burritos"
    And I should see "Tacos"
    And I should see "Choices and Additions"

  Scenario: Checking prices
    Given I want to see what Ohio City Burrito serves
    When I touch the menu sign
    Then I should see the prices:
      | Brother's Burrito | $6.45 |
      | Baby Burrito      | $1.85 |
