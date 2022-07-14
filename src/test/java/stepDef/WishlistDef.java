package stepDef;

import io.cucumber.java.en.Then;
import pages.WishlistPage;
import services.PageObjectManager;

public class WishlistDef {
	
	WishlistPage wishlistPage = PageObjectManager.getWishlistPage();

	@Then("verify the product details in wishlist")
	public void verify_the_product_details_in_wishlist() {
		wishlistPage.verifyProductInWishlist();
		
	}

	@Then("click the remove action button to remove")
	public void click_the_remove_action_button_to_remove() {
		wishlistPage.removeFromWishList();
	}

	@Then("verify emplty wishlist")
	public void verify_emplty_wishlist() {
	}

}
