package stepDef;

import io.cucumber.java.en.Then;
import pages.CheckoutPage;
import services.PageObjectManager;

public class CheckoutDef {
	
	CheckoutPage checkoutPage = PageObjectManager.getCheckoutPage();
	
	@Then("select existing address and click on continue button for billing details")
	public void select_existing_address_and_click_on_continue_button_for_billing_details() {
		checkoutPage.fillBillingDetailsExisting();
		checkoutPage.clickContinueButtonBD();
	}

	@Then("select existing address and click on continue button for delivery details")
	public void select_existing_address_and_click_on_continue_button_for_delivery_details() {
		checkoutPage.fillDeliveryDetailsExisting();
		checkoutPage.clickContinueButtonDD();
	}

	@Then("select flat shipping rate and click on continue button for delivery method")
	public void select_flat_shipping_rate_and_click_on_continue_button_for_delivery_method() {
		checkoutPage.fillDeliveryMethods();
		checkoutPage.clickContinueButtonDM();
	}

	@Then("select cash on delivery and agree TC and click on continue button for payment method")
	public void select_cash_on_delivery_and_agree_tc_and_click_on_continue_button_for_payment_method() {
		checkoutPage.fillPaymentMethod();
		checkoutPage.checkTermsAndConditions();
		checkoutPage.clickContinueButtonPM();
	}

	@Then("verify the order details and price for confirm order")
	public void verify_the_order_details_and_price_for_confirm_order() {
		checkoutPage.verifyConfirmOrder();
	}

	@Then("click the confirm order button")
	public void click_the_confirm_order_button() {
		checkoutPage.clickConfirmOrderButton();
	}

	@Then("verify the successfully placed order message")
	public void verify_the_successfully_placed_order_message() {
		checkoutPage.verifyConfirmPlacedStatus();
	}


}
