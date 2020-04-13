@Test12345
Feature: User would like to get test12345s

  Scenario: User should be able to get all test12345s
    Given the following test12345s exists in the library
      | description                 |
      | Twinkle twinkle little star |
    When user requests for all test12345s
    Then the user gets the following test12345s
      | description                 |
      | Twinkle twinkle little star |
