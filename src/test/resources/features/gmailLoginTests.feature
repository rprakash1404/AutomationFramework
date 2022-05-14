

@login
Feature: Test Gmail login

  Scenario Outline: Title of your scenario
    Given I navigate to gmail login page
    When I enter valid <username>
    And I enter invalid <password>
    And I click login button
    Then I should get login error

    Examples:
      | username           | password   |
      | "ratneshprakash06" | "you wish" |