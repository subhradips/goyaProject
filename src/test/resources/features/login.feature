Feature: Spring 1 goya project senario
  Scenario: Login Page
    Given I am on the Login page
    When  I should see Sign In Page
    Then  I enter username
    Then  I enter password
    Then  user clicks on login button
    And   user is logged in

  Scenario: Dashboard
    Given user is home page
    When I should customers tab click
    Then customers Page verify
    Then given input search customer textbox
    Then chose customer
    Then select button click
    Then then process button click
    Then you have enter home page verify
    Then header file change name verify