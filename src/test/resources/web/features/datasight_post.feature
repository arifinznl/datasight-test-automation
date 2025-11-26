@web @post
Feature: Dashboard Login

  @create-post
  Scenario: create post content
    Given User is on Datasight dashboard login page
    When User input dashboard email "dummyuser@gmail.com"
    And User input dashboard password "dummyuser1!"
    When User click dashboard login button
    Then User should be redirected to Datasight dashboard homepage
    And User navigate to post management page
    When User input title "New Energi"
    And User input Title (English) "New Energy"
    And User input Slug "new-energy"
    When User click Add New Post Button
    Then Post should be created successfully

  Scenario: Delete post content
    Given User is on Datasight dashboard login page
    When User input dashboard email "dummyuser@gmail.com"
    And User input dashboard password "dummyuser1!"
    When User click dashboard login button
    Then User should be redirected to Datasight dashboard homepage
    And User navigate to post management page
    When User delete post with title "New Energi"
    Then Post "New Energi" should no longer appear in the list