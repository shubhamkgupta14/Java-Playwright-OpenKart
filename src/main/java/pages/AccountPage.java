package pages;

import static org.testng.Assert.assertEquals;

import java.nio.file.Paths;
import java.util.List;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

import services.ConfigReader;
import utils.Constants;
import utils.Utils;

public class AccountPage {

	Page page;
	Utils util = new Utils();

	public AccountPage(Page page) {
		super();
		this.page = page;
	}

	private String lbl_accountTitles = "#content h2";
	private String btn_home = "#logo h1 a";

	public void verifyAllTitles() {
		util.verifyTitle(page, Constants.AccountPageTitle);

		List<ElementHandle> loc = page.querySelectorAll(lbl_accountTitles);

		int index = 0;
		for (ElementHandle ele : loc) {
			if (ele.textContent().equals(Constants.accountPageAllTitles[index])) {
				index++;
			} else {
				assertEquals(ele.textContent(), Constants.accountPageAllTitles[index]);
			}
		}
	}

	public void clickHomeButton() {
		page.click(btn_home);
		page.waitForURL(new ConfigReader().getPropertyValue("route_home"));
		
		// Verifying FullPage Screenshot
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("fullPageSnap.png")).setFullPage(true));
	}

}
