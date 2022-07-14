package pages;

import java.nio.file.Paths;
import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
//import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import services.ConfigReader;
import utils.Constants;
import utils.Utils;

public class HomePage {

	Page page;
	Utils util = new Utils();
	ConfigReader cfReader = new ConfigReader(util.getPropertyFileName());

	public HomePage(Page page) {
		super();
		this.page = page;
	}

	private String lbl_logo = "div#logo > a > img";
	private String dropdown_user = "#top .dropdown:last-child";
	private String btn_login = "#top .dropdown:last-child > ul > li:last-child > a";
	private String btn_logout = "#top .dropdown:last-child > ul > li:last-child > a";
	private String btn_orderHistory = "#top-links .dropdown > ul > li:nth-child(2) > a";
	private String btn_register = "#top-links .dropdown > ul > li:first-child > a";
	private String input_search = "input[name=search]";
	private String btn_search = "#search .btn";
	private String lbl_productionTitle = ".product-layout .caption > h4 a";

	public void verifyHomePage() {
//		assertEquals(page.textContent(lbl_logo), Constants.storeLogo);
		util.verifyTitle(page, Constants.HomePageTitle);
	}

	public void gotoLoginPage() {
		page.locator(dropdown_user).click();
		page.locator(btn_login).click();
		page.waitForURL(new ConfigReader().getPropertyValue("route_login"));
	}
	
	public void gotoRegisterPage() {
		page.locator(dropdown_user).click();
		page.locator(btn_register).click();
		page.waitForURL(new ConfigReader().getPropertyValue("route_register"));
	}

	public void searchProdct() {
		String productName = cfReader.getPropertyValue("searchProduct");
		page.fill(input_search, productName);
		util.setProductVariable(Constants.productName, productName);
		page.locator(btn_search).click();
		page.waitForURL(new ConfigReader().getPropertyValue("route_searchProduct"));
	}
	
	public void searchWrongProdct() {
		String productName = cfReader.getPropertyValue("searchWrongProduct");
		page.fill(input_search, productName);
		util.setProductVariable(Constants.productName, productName);
		page.locator(btn_search).click();
		page.waitForURL(new ConfigReader().getPropertyValue("route_searchProduct"));
	}
	
	public void selectProduct() {
		util.verifyTitle(page, Constants.searchPageTitle + util.getProductVariable(Constants.productName));
		util.scrollToDown(page, 250);

		List<ElementHandle> loc = page.querySelectorAll(lbl_productionTitle);

		if (loc.size() >= 1) {
			for (ElementHandle ele : loc) {
				if (ele.textContent().equals(util.getProductVariable(Constants.productName))) {
					ele.click();
					break;
				} else {
					System.out.println("Here");
				}
			}
		} // else if (loc.size() == 0) {
			// TODO
			//System.out.println("Product not found");
		//}
		page.waitForURL(new ConfigReader().getPropertyValue("route_searchedProductDetail"));
	}

	public void clickOrderButton() {
		page.locator(dropdown_user).click();
		page.locator(btn_orderHistory).click();
		page.waitForURL(new ConfigReader().getPropertyValue("route_order"));
	}

	public void clickLogoutButton() {
		page.locator(dropdown_user).click();
		page.locator(btn_logout).click();
		page.waitForURL(new ConfigReader().getPropertyValue("route_logout"));
	}
}
