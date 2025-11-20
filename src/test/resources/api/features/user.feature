@api @user
Feature: User API Testing

  Scenario: CRUD user flow
    When Create user with email "testdummy@mail.com" firstname "Zen1" lastname "Zen2"
    Then Response status code should be 200

    When Get that user
    Then Response status code should be 200

    When Update user firstname to "ZenUpdated"
    Then Response status code should be 200

    When Delete the user
    Then Response status code should be 200

  Scenario: Create user with invalid email
    When Create user with email "testdummy" firstname "Zen1" lastname "Zen2"
    Then Response status code should be 400
