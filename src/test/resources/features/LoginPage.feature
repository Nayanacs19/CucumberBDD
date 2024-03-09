Feature: Login functionality for HRM Website

  As a user of the HRM website
  I want to be able to login with my credentials
  So that I can access my account

  Background:
    Given I am on the HRM login page

    Scenario: Successful login with valid credentials
      Given I have entered valid username and password
      When I click on the login button
      Then I should be logged in successfully

    Scenario Outline:Unsuccessful login with invalid credentials
      Given I have entered invalid <username> and <password>
      When I click on the login button
      Then I should see an error message <error_message>

      Examples:
      |username     |password   |error_message      |
      |xyz          |rtt456     |Invalid credentials|
      |abcd_g@th.com|ert456     |Invalid credentials|

      Scenario: Navigating to the Reset Password Page
        When I click on "Forgot your password?" link
        Then I shoudld be redirected to password reset page