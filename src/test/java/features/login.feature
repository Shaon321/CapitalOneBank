Feature: Login feature test
  @login
  Scenario: Login with valid email and password
    Given I am at Capital One Bank Homepage
    And I enter a valid email address
    And I enter a invalid password
    When I click on Login Button
    Then I should not be able to successfully log in
    Then I able to get an error message
    Then i clicked on OK button to return to SignIn page
    Then I am at SignIn page
    Then I put some private data & get Account Info
