package pages;

import static org.testng.Assert.assertEquals;

import com.microsoft.playwright.Page;

import services.ConfigReader;
import utils.Constants;
import utils.Utils;

public class CartPage {

	Page page;
	Utils util = new Utils();

	public CartPage(Page page) {
		super();
		this.page = page;
	}


	private String lbl_productName = "tbody:nth-child(2) tr td:nth-child(2) a";
	private String lbl_productModel = "tbody:nth-child(2) tr td:nth-child(3)";
	private String lbl_quantity = "tbody:nth-child(2) tr td:nth-child(4) input";
	private String lbl_unitPrice = "tbody:nth-child(2) tr td:nth-child(5)";
	private String lbl_sumPrice = "tbody:nth-child(2) tr td:nth-child(6)";
	private String btn_checkOut = ".buttons .pull-right a";



	public void verifyProductDetail() {
		util.verifyTitle(page, Constants.CartPageTitle);
		System.out.println(Constants.productMap);
		
		assertEquals(page.textContent(lbl_productName), util.getProductVariable(Constants.productName));
		assertEquals(page.textContent(lbl_productModel), util.getProductVariable(Constants.productModel));
		assertEquals(page.locator(lbl_quantity).inputValue(), util.getProductVariable(Constants.productQuantity));

		String totalPriceCalc = util.getTotalPrice(page.locator(lbl_quantity).inputValue(),
				page.textContent(lbl_unitPrice));

		util.setProductVariable(Constants.productTotalPrice, "$" + totalPriceCalc);

		assertEquals(page.textContent(lbl_sumPrice).contains("$" + totalPriceCalc), true);
	}

	public void verifyPricingDetails() {
	}

	public void clickCheckOutButon() {
		util.scrollToDown(page, 300);
		page.click(btn_checkOut);
		page.waitForURL(new ConfigReader().getPropertyValue("route_checkout"));
	}

}
