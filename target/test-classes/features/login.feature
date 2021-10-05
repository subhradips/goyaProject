Feature: Spring 1 goya project senario
  Scenario: Login Page
    Given I am on the Login page
    When  I should see Sign In Page
    Then  I enter username
    Then  I enter password
    Then  user clicks on login button

#  Scenario: Dashboard
#    Given user is home page
#    When I should customers tab click
#    Then customers Page verify
#    Then given input search customer textbox
#    Then chose customer
#    Then select button click
#    Then then process button click
#    Then you have enter home page verify
#    Then header file change name verify

  Scenario: Order
    Given user is home page
    When I should Order tab click
    Then Order Page verify
    Then Customer dropdown select Customer
    Then Search Item Button click
    Then Search Items value in the textBox
    Then Click Add to Cart Button
    Then Enter Quality amount
    Then pop_up Add to Cart Button Click
    Then Continue Button Click
    Then Store EOR Data
    Then Submit button click

    Scenario: Order Status
      Given user is home page
      When I should Order Status tab click
      Then Order status Page verify
      Then Customer dropdown select Customer
      Then Search EOR number
      Then Product Edit
      Then Search Item Button click
      Then Search Items value in the textBox
      Then Click Add to Cart Button
      Then Enter Quality amount
      Then pop_up Add to Cart Button Click
      Then Continue Button Click
      Then Store EOR Data
      Then Submit button click
