package stepDef;

import io.cucumber.java.en.Then;
import pages.CartPage;
import services.PageObjectManager;

public class CartDef {

	CartPage cartPage = PageObjectManager.getCartPage();

	@Then("verify the added product in cart")
	public void verify_the_added_product_in_cart() {
		cartPage.verifyProductDetail();
	}

	@Then("verify the pricing details of the product")
	public void verify_the_pricing_details_of_the_product() {
		cartPage.verifyPricingDetails();
	}

	@Then("click on checkout button")
	public void click_on_checkout_button() {
		cartPage.clickCheckOutButon();
	}
}
