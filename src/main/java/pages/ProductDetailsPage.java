package pages;

import static org.testng.Assert.assertEquals;

import com.microsoft.playwright.Page;

import io.cucumber.java.Scenario;
import services.ConfigReader;
import utils.Constants;
import utils.Utils;

public class ProductDetailsPage {

	Page page;
	Utils util = new Utils();
	Scenario scenario;
	ConfigReader cfReader = new ConfigReader(util.getPropertyFileName());

	public ProductDetailsPage(Page page) {
		super();
		this.page = page;
	}

	private String lbl_prodTitle = "#content h1";
	private String lbl_prodModel = "(//ul[@class='list-unstyled'])[8]/li[2]";
	private String input_quantity = "input[name='quantity']";
	private String btn_addToCart = "button#button-cart";
	private String lbl_prdctPrice = "#content li h2";
//	private String lbl_taxPrice = "(//ul[@class='list-unstyled'])[9]/li[2]";
	private String lbl_availability = "(//ul[@class='list-unstyled'])[8]/li[4]";
	private String alert_success = ".alert-success";
	private String btn_cart = "a[title='Shopping Cart']";
	private String btn_addWishlist = "button .fa-heart";
	private String btn_wishlist = "li a#wishlist-total";

	public void verifyProductDetails() {
		util.verifyTitle(page, util.getProductVariable(Constants.productName));
		assertEquals(page.textContent(lbl_prodTitle), util.getProductVariable(Constants.productName));
		String modelName = page.textContent(lbl_prodModel);
		String stock = page.textContent(lbl_availability);
		util.setProductVariable(Constants.productModel, modelName.substring(modelName.indexOf(":") + 2));
		util.setProductVariable(Constants.productUnitPrice, page.textContent(lbl_prdctPrice));
		util.setProductVariable(Constants.productStock, stock.substring(modelName.indexOf(":") + 2));
	}

	public void checkInStockAvailability() {
		assertEquals(page.textContent(lbl_availability), Constants.productAvail);
	}

	public void checkOutOfStockAvailability() {
		assertEquals(page.textContent(lbl_availability), Constants.productNotAvail);
	}

	public void selectQuantity() {
		String qty = cfReader.getPropertyValue("quantity");
		page.fill(input_quantity, "");
		page.fill(input_quantity, qty);
		util.setProductVariable(Constants.productQuantity, qty);
	}

	public void clickAddToCart() {
		util.scrollToDown(page, 500);
		page.locator(btn_addToCart).click();;
	}

	public void verifySuccessAlertCart() {
		util.scrollToUp(page, 500);
		System.out.println(page.textContent(alert_success));
		assertEquals(page.textContent(alert_success).contains(
				Constants.addToCartSuccess.replace("*", util.getProductVariable(Constants.productName))), true);
	}

	public void clickCartButton() {
		util.scrollToUp(page, 200);
		page.click(btn_cart);
		page.waitForURL(new ConfigReader().getPropertyValue("route_cart"));
	}

	public void addToWishlist() {
		page.locator(btn_addWishlist).click();
	}

	public void gotoWishlistPage() {
		page.locator(btn_wishlist).click();;
		page.waitForURL(new ConfigReader().getPropertyValue("route_wishlist"));
	}

	public void verifySuccessAlertWishlist() {
		util.scrollToUp(page, 500);
		assertEquals(
				page.textContent(alert_success).contains(
						Constants.addToWishlistSuccess.replace("*", util.getProductVariable(Constants.productName))),
				true);
	}

}
