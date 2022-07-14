#Author: your.email@your.domain.com
@openkart
Feature: Openkart - Successfully place an order

@place_success
  Scenario: Performing succussfully place an order
    Given user is on home page
    And click on login button
    When enters email and password to login
    And verifies the user account page
    And goto the product homepage
    And search for a product
    And select the searched product
    And verify the product details
    And verify the availability of the product as In Stock
    And select the quantity of the product
    And clicks the add to cart button
    And verify the success message after adding to cart
    And goto the cart page
    Then verify the added product in cart
    And verify the pricing details of the product
    And click on checkout button
    And select existing address and click on continue button for billing details
    And select existing address and click on continue button for delivery details
    And select flat shipping rate and click on continue button for delivery method
    And select cash on delivery and agree TC and click on continue button for payment method
    And verify the order details and price for confirm order
    And click the confirm order button
    And verify the successfully placed order message
    And goto the order page
    And verify the placed order in order history
    And logout the user