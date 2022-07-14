package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.microsoft.playwright.Page;

import services.ConfigReader;
import utils.Constants;
import utils.Utils;

public class CheckoutPage {

	Page page;
	Utils util = new Utils();

	public CheckoutPage(Page page) {
		super();
		this.page = page;
	}

	private String radio_existingAddrBD = "input[name=payment_address][value=existing]";
//	private String radio_newAddrBD = "input[name=payment_address][value=new]";
	private String btn_continueBD = "input#button-payment-address";
	private String radio_existingAddrDD = "input[name=shipping_address][value=existing]";
//	private String radio_newAddrDD = "input[name=shipping_address][value=new]";
	private String btn_continueDD = "input#button-shipping-address";
	private String radio_flatRateDM = "input[name=shipping_method][value='flat.flat']";
	private String btn_continueDM = "input#button-shipping-method";
	private String radio_codPM = "input[name=payment_method][value=cod]";
	private String chk_termsPM = "input[name=agree][value='1']";
	private String btn_continuePM = "input#button-payment-method";
	private String lbl_prodNameCO = "tbody:nth-child(2) tr td:nth-child(1) a";
	private String lbl_prodModelCO = "tbody:nth-child(2) tr td:nth-child(2)";
	private String lbl_prodQtyCO = "tbody:nth-child(2) tr td:nth-child(3)";
	private String lbl_unitPriceCO = "tbody:nth-child(2) tr td:nth-child(4)";
	private String lbl_totalPriceCO = "tbody:nth-child(2) tr td:nth-child(5)";
	private String btn_confirmOrder = "input#button-confirm";
	public String lbl_successPlaced = "#content h1";
	private String btn_successContinue = ".buttons .pull-right a";

	public void fillBillingDetailsExisting() {
		util.verifyTitle(page, Constants.CheckoutPageTitle);
		page.check(radio_existingAddrBD);
		assertTrue(page.isChecked(radio_existingAddrBD));
	}

	public void fillBillingDetailsNew() {
	}

	public void clickContinueButtonBD() {
		page.click(btn_continueBD);
	}

	public void fillDeliveryDetailsExisting() {
		page.check(radio_existingAddrDD);
		assertTrue(page.isChecked(radio_existingAddrDD));
	}

	public void fillDeliveryDetailsNew() {
	}

	public void clickContinueButtonDD() {
		page.click(btn_continueDD);
	}

	public void fillDeliveryMethods() {
		page.check(radio_flatRateDM);
	}

	public void clickContinueButtonDM() {
		page.click(btn_continueDM);
	}

	public void fillPaymentMethod() {
		page.check(radio_codPM);
	}

	public void checkTermsAndConditions() {
		page.check(chk_termsPM);
	}

	public void clickContinueButtonPM() {
		page.click(btn_continuePM);
	}

	public void verifyConfirmOrder() {
		assertEquals(page.textContent(lbl_prodNameCO), util.getProductVariable(Constants.productName));
		assertEquals(page.textContent(lbl_prodModelCO), util.getProductVariable(Constants.productModel));
		assertEquals(page.textContent(lbl_prodQtyCO), util.getProductVariable(Constants.productQuantity));
		assertEquals(page.textContent(lbl_unitPriceCO).contains(util.getProductVariable(Constants.productUnitPrice)), true);
		assertEquals(page.textContent(lbl_totalPriceCO).contains(util.getProductVariable(Constants.productTotalPrice)), true);
	}

	public void clickConfirmOrderButton() {
		page.click(btn_confirmOrder);
		page.waitForURL(new ConfigReader().getPropertyValue("route_successPlaced"));
	}
	
	public void verifyConfirmPlacedStatus() {
		assertEquals(page.textContent(lbl_successPlaced), Constants.placedSuccess);
		page.locator(btn_successContinue).click();
		page.waitForURL(new ConfigReader().getPropertyValue("route_home"));
	}

}
