@login
Feature: Login to saucedemo

  As a user login to saucedemo website
  I want to be able to log in with my account
  So that I can order product from page

  Background:
    Given I am login to saucedemo website

  @login-success
  Scenario: Successful login with valid credentials
    Given I have fill username "standard_user" and password "secret_sauce"
    When I click on the "login-button" button
    Then I should be logged in successfully