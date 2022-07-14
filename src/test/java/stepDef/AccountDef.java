package stepDef;

import io.cucumber.java.en.When;
import pages.AccountPage;
import services.PageObjectManager;

public class AccountDef {

	AccountPage accountPage = PageObjectManager.getAccountPage();

	@When("verifies the user account page")
	public void verifies_the_user_account_page() {
		accountPage.verifyAllTitles();
	}

	@When("goto the product homepage")
	public void goto_the_product_homepage() {
		accountPage.clickHomeButton();
	}

}
