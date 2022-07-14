#Author: your.email@your.domain.com
@openkart
Feature: Openkart - Login Logout

@login_logout
  Scenario: Performing login and logout operation
    Given user is on home page
    And click on login button
    When enters email and password to login
    And verifies the user account page
    And logout the user