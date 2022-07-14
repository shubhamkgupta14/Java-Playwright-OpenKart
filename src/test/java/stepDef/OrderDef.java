package stepDef;

import io.cucumber.java.en.Then;
import pages.OrderPage;
import services.PageObjectManager;

public class OrderDef {

	OrderPage orderPage = PageObjectManager.getOrderPage();

	@Then("verify the placed order in order history")
	public void verify_the_placed_order_in_order_history() {
	    
	}
}
