
Feature: Create account
  I want to use this template for my feature file

   Scenario Outline: Title of your scenario outline
    Given I have logged in
    And I have entered a <email>
    When I have entered a <email>
    Then I verify the <status> in step

    Examples: 
      | email  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
