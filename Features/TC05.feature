Feature: Filter Four-Star Hotels

  Scenario: Successful Search Result Filteration
    Given User is on Home Page
    When User Searches for a hotel
    And User checks the four-stars checkmark
    Then Four-star hotels displayed successfully

  
