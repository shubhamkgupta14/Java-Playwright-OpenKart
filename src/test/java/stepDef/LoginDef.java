package stepDef;

import io.cucumber.java.en.When;
import pages.LoginPage;
import services.PageObjectManager;

public class LoginDef {

	LoginPage loginPage = PageObjectManager.getLoginPage();

	@When("enters email and password to login")
	public void enters_email_and_password_to_login() {
		loginPage.enterEmail();
		loginPage.enterPassword();
		loginPage.clickLoginButton();
	}

}
