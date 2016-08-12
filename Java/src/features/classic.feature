Feature: Quality changes with sell-in date Feature
  In order to keep track of quality of items in stock
  As a ShopKeeper
  I want quality to change as the sell-in date decreases
    
  Scenario: Decreasing Quality of a Basic Item
    Given an item "+5 Dexterity Vest"
    And the sell in is 5
    And the quality is 7
    When I update quality
    Then the sell in is updated to 4
    And the quality is updated to 6

  Scenario: Quality decrease doubles after sell-in has passed
    Given an item "+5 Dexterity Vest"
    And the sell in is 0
    And the quality is 10
    When I update quality
    Then the sell in is updated to -1
    And the quality is updated to 8

  Scenario: Quality never becomes negative
    Given an item "+5 Dexterity Vest"
    And the sell in is 0
    And the quality is 0
    When I update quality
    Then the sell in is updated to -1
    And the quality is updated to 0

  Scenario: Quality of Aged Brie increases with age
    Given an item "Aged Brie"
    And the sell in is 5
    And the quality is 1
    When I update quality
    Then the sell in is updated to 4
    And the quality is updated to 2

  Scenario: Quality of Aged Brie never increases past 50
    Given an item "Aged Brie"
    And the sell in is 5
    And the quality is 50
    When I update quality
    Then the sell in is updated to 4
    And the quality is updated to 50

  Scenario: Quality of Backstage Passes increases by 1 if sell-in is greater than 10
    Given an item "Backstage passes to a TAFKAL80ETC concert"
    And the sell in is 11
    And the quality is 20
    When I update quality
    Then the quality is updated to 21

  Scenario: Quality of Backstage Passes increases by 2 if sell-in is less than 10 but more than 5
    Given an item "Backstage passes to a TAFKAL80ETC concert"
    And the sell in is 6
    And the quality is 20
    When I update quality
    Then the quality is updated to 22

  Scenario: Quality of Backstage Passes increases by 3 if sell-in is 5 or less but more than 0
    Given an item "Backstage passes to a TAFKAL80ETC concert"
    And the sell in is 5
    And the quality is 20
    When I update quality
    Then the quality is updated to 23

  Scenario: Quality of Backstage Passes is 0 after the concert (sell-in) passes
    Given an item "Backstage passes to a TAFKAL80ETC concert"
    And the sell in is 0
    And the quality is 20
    When I update quality
    Then the quality is updated to 0

  Scenario: Quality and SellIn of a Sulfuras item does not change
    Given an item "Sulfuras, Hand of Ragnaros"
    And the sell in is 5
    And the quality is 7
    When I update quality
    Then the sell in is updated to 5
    And the quality is updated to 7