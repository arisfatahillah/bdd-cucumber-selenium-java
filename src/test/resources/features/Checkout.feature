@checkout
Feature: Checkout product

  As a user login to saucedemo website
  I want checkout product from highest price on list

  Background:
    Given I am login to saucedemo website
    Given I have fill username "standard_user" and password "secret_sauce"
    When I click on the "login-button" button
    Then I should be logged in successfully

  Scenario: User can checkout product with highest price on list
    Given I get price list from product
    And User sorting price based on "hilo" value
    And I get highest product price list after sorting
    When I click first cart button on product list
    And I click on the "shopping_cart_link" link
    And validate product name with highest price on checkout page
    And I click on the "checkout" button
    And I fill textfield "firstName" with value "Abang"
    And I fill textfield "lastName" with value "Ganteng"
    And I fill textfield "postalCode" with value "40132"
    And I click on the "continue" button
    And I validate text "Shipping Information" exist on page
    And I validate text "Free Pony Express Delivery!" exist on page
    And I click on the "finish" button
    Then I validate text "Thank you for your order!" exist on page

