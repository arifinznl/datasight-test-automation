@api @tag
Feature: Tag API Test

  Scenario: Get tag list
    When Get list of tags
    Then Tags response status should be 200
