Feature: Register Flow Test Suite

  @Regression @Smoke
  Scenario: Access the Account page after successful registration
    Given The Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid random data
    And the privacyPolicyToggle is enabled
    And continueButton is clicked
    Then the new page url contains "=account/success&l" keyword

  Scenario: User remains on Register page when continue button is not clicked during the register flow
    Given The Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid random data
    And the privacyPolicyToggle is enabled
    Then the new page url contains "route=account/register&language=en-gb" keyword

  Scenario: User remains on Register page when privacy conditions are not accepted during the register flow
    Given The Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid random data
    And continueButton is clicked
    Then the new page url contains "route=account/register&language=en-gb" keyword