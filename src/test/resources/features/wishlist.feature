#Author: your.email@your.domain.com
@openkart
Feature: Openkart - Adding and Removing the product into wishlist

@wishlist
  Scenario: Performing adding and removing the product into wishlist
    Given user is on home page
    And click on login button
    When enters email and password to login
    And verifies the user account page
    And goto the product homepage
    And search for a product
    And select the searched product
    And verify the product details
    And click on the wishlist button to add
    And verify the success message after adding to wishlist
    Then goto the wishlist page
    And verify the product details in wishlist
    And click the remove action button to remove
    And verify emplty wishlist
    And logout the user
    