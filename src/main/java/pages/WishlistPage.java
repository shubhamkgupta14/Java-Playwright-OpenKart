package pages;

import static org.testng.Assert.assertEquals;

import com.microsoft.playwright.Page;

import utils.Constants;
import utils.Utils;

public class WishlistPage {

	Page page;
	Utils util = new Utils();
	
	public WishlistPage(Page page) {
		super();
		this.page = page;
	}
	
	private String lbl_productName = "#content tbody tr td:nth-child(2) a";
	private String lbl_modelName = "#content tbody tr td:nth-child(3)";
	private String lbl_stock = "#content tbody tr td:nth-child(4)";
	private String lbl_unitPrice = "#content tbody tr td .price";
	private String btn_wishlistRemove = "#content tbody tr td:nth-child(6) a";
	private String alert_successRemove = "div.alert";
	private String lbl_empltyWishlist = "#content p";
	
	public void verifyProductInWishlist() {
		util.verifyTitle(page, Constants.WishlistPageTitle);
		assertEquals(page.textContent(lbl_productName).trim(), util.getProductVariable(Constants.productName));
		assertEquals(page.textContent(lbl_modelName).trim(), util.getProductVariable(Constants.productModel));
		assertEquals(page.textContent(lbl_stock).trim(), util.getProductVariable(Constants.productStock));
		assertEquals(page.textContent(lbl_unitPrice).trim(), util.getProductVariable(Constants.productUnitPrice));
	}

	public void removeFromWishList() {
		page.click(btn_wishlistRemove);
	}
	
	public void verifyEmptyWishlist() {
		assertEquals(page.textContent(alert_successRemove).trim(), util.getProductVariable(Constants.removedSuccessFromWishlist));
		assertEquals(page.textContent(lbl_empltyWishlist).trim(), util.getProductVariable(Constants.labelEmptyWishlist));
	}
	
	
	
	
}
