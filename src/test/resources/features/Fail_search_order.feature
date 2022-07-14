#Author: your.email@your.domain.com
@openkart
Feature: Openkart - Search a product

@search_product
  Scenario: Performing search product operation
    Given user is on home page
    And click on login button
    When enters email and password to login
    And verifies the user account page
    And goto the product homepage
    And search for a wrong product
    And select the searched product
    And logout the user