package utils;

import static org.testng.Assert.assertEquals;

import com.microsoft.playwright.Page;

public class Utils {

	public void setProductVariable(String key, String val) {
		Constants.productMap.put(key, val);
	}

	public String getProductVariable(String key) {
		return Constants.productMap.get(key);
	}

	public void scrollToUp(Page page, int axis) {
		page.mouse().wheel(0, -axis);
	}

	public void scrollToDown(Page page, int axis) {
		page.mouse().wheel(0, axis);
	}
	
	public void verifyTitle(Page page, String pageType) {
		assertEquals(page.title(), pageType);
	}

	public String getTotalPrice(String qty, String unitPrice) {
		int quantity = Integer.parseInt(qty);
		double price = Double.parseDouble(unitPrice.substring(1));

		return (quantity * price) + "";
	}

	public String getPriceAfterConfirm() {
		return "";
	}

	public String getPropertyFileName() {
		return "data/data.properties";
	}

}
