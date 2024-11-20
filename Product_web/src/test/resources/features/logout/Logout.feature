Feature: Sign out of your account
  @Logout
  Scenario: Sign out of your account success
    Given I am on the login page
    When I enter my username and password
    And I click the Login button
    And I click the Logout button
    Then Verify logout success
