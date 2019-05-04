Feature: Values Page Functional

  Background:
    Given User on Values Page

  Scenario: Count of values is correct
    Then Assert count of labels equals count of text values

  Scenario: Values are greater than 0
    Then Assert every value on the screen is greater than 0

  Scenario: Total balance is correct
    Then Assert the total balance is equal the sum of values

  Scenario: Currencies format checking
    Then  Assert the values are formatted as currencies













