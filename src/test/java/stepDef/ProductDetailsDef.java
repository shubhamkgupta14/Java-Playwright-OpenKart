package stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductDetailsPage;
import services.PageObjectManager;

public class ProductDetailsDef {

	ProductDetailsPage productDlPage = PageObjectManager.getProductDetailsPage();

	@When("verify the product details")
	public void verify_the_product_details() {
		productDlPage.verifyProductDetails();
	}

	@When("verify the availability of the product as In Stock")
	public void verify_the_availability_of_the_product_as_in_stock() {
		productDlPage.checkInStockAvailability();
	}

	@When("select the quantity of the product")
	public void select_the_quantity_of_the_product() {
		productDlPage.selectQuantity();
	}

	@When("clicks the add to cart button")
	public void clicks_the_add_to_cart_button() {
		productDlPage.clickAddToCart();
	}

	@When("verify the success message after adding to cart")
	public void verify_the_success_message_after_adding_to_cart() {
		productDlPage.verifySuccessAlertCart();
	}
	
	@When("goto the cart page")
	public void goto_the_cart_page() {
		productDlPage.clickCartButton();
	}
	
	@When("click on the wishlist button to add")
	public void click_on_the_wishlist_button_to_add() {
		productDlPage.addToWishlist();
	}
	
	@Then("goto the wishlist page")
	public void goto_the_wishlist_page() {
		productDlPage.gotoWishlistPage();
	}
	
	@When("verify the success message after adding to wishlist")
	public void verify_the_success_message_after_adding_to_wishlist() {
		productDlPage.verifySuccessAlertWishlist();
	}

}
