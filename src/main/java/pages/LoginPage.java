package pages;

import com.microsoft.playwright.Page;

import services.ConfigReader;
import utils.Constants;
import utils.Utils;

public class LoginPage {

	Page page;
	Utils util = new Utils();
	ConfigReader cfReader = new ConfigReader(util.getPropertyFileName());

	public LoginPage(Page page) {
		super();
		this.page = page;
	}

	private String input_email = "#input-email";
	private String input_password = "#input-password";
	private String btn_login = "input[value='Login']";

	public void enterEmail() {
		util.verifyTitle(page, Constants.LoginPageTitle);
		page.fill(input_email, cfReader.getPropertyValue("email"));
	}

	public void enterPassword() {
		page.fill(input_password, cfReader.getPropertyValue("password"));
	}

	public void clickLoginButton() {
		page.click(btn_login);
		page.waitForURL(new ConfigReader().getPropertyValue("route_account"));
	}

}
