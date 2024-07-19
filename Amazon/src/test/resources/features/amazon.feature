Feature: Amazon Search

Background:
Given I am on the Amazon homepage
    

  Scenario: Search for a product by name
    When I enter "laptop" into the search bar
    And I click the search button
    Then I should see search results for "laptop"
    And the search results should include products with "laptop" in their name

      Scenario: No results found
    When I enter "unicorn spaceship" into the search bar
    And I click the search button
    Then I should see a message saying "No results found for 'unicorn spaceship'"
    
    
  Scenario: Search for a specific category
    When I enter "Harry Potter" into the search bar
    And I click the search button
    Then I should see search results for "Harry Potter" in the Books category
    
  

  Scenario: Search with partial keywords
    When I enter "wireless ear" into the search bar
    And I click the search button
    Then I should see search results that include "wireless earbuds" and "wireless earphones"
    
    