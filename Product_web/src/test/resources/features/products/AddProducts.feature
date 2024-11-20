Feature: I want to add product

  @Add1itemtocartsuccess
  Scenario: Add new product in cart
    Given I am on the login page
    When I enter my username and password
    And I click the Login button
    And I add product success
    And I view shop card
    And I checkout product success
    Then Verify checkout success
@GetTitleProduct
    Scenario: View detail product
      Given I am on the login page
      When I enter my username and password
      And I click the Login button
      And I want to get title all product