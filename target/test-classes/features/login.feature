Feature: Spring 1 goya project scenario

  Scenario: Login Page
    Given I am on the Login page
    When  I should see Sign In Page
    Then  I enter username
    Then  I enter password
    Then  user clicks on login button

  Scenario: Customer
    Given user is home page
    When i click customers tab
    Then customers Page verify
    Then given input search customer textbox
    Then choose customer
    Then click on select button
    Then click on process button
    Then you have enter home page verify


  Scenario: Order
    Given user is home page
    When click on Order tab
    Then order Page verify
    Then customer dropdown select Customer
    Then click on Search Item Button
    Then search Items value in the textBox
    Then click on Add to Cart Button
    Then enter Quantity
    Then click on pop_up Add to Cart Button
    Then click on continue Button
    Then store EOR Data
    Then click on Submit button


    Scenario: Order Status
      Given user is home page
      When i click on Order Status tab
      Then customer Order Status dropdown select Customer
      Then Store EOR Data input

