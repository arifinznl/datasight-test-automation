@web @login
Feature: Dashboard Login

  @valid-login
  Scenario: Login dashboard with valid credentials
    Given User is on Datasight dashboard login page
    When User input dashboard email "dummyuser@gmail.com"
    And User input dashboard password "dummyuser1!"
    When User click dashboard login button
    Then User should be redirected to Datasight dashboard homepage

  @empty-email-password
  Scenario: Login with empty email and password
    Given User is on Datasight dashboard login page
    When User input dashboard email ""
    And User input dashboard password ""
    When User click dashboard login button
    Then Email field should show invalid email message

  @empty-password
  Scenario: Login with password empty and valid email
    Given User is on Datasight dashboard login page
    When User input dashboard email "dummyuser@gmail.com"
    And User input dashboard password ""
    When User click dashboard login button
    Then Password field should show required field message

  @wrong-password
  Scenario: Login with wrong password
    Given User is on Datasight dashboard login page
    When User input dashboard email "dummyuser@gmail.com"
    And User input dashboard password "wrongpassword!"
    When User click dashboard login button
    Then Error message should appear for "Invalid credentials"

  @unregistered-user
  Scenario: Login with valid email format but unregistered user
    Given User is on Datasight dashboard login page
    When User input dashboard email "notregistered@gmail.com"
    And User input dashboard password "dummyuser1!"
    When User click dashboard login button
    Then Error message should appear for "Invalid credentials"

  @invalid-email-format
  Scenario: Login with email without at symbol
    Given User is on Datasight dashboard login page
    When User input dashboard email "invalidemail"
    And User input dashboard password "dummyuser1!"
    When User click dashboard login button
    Then Email field should show invalid email message
