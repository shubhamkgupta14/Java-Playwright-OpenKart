package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import services.ConfigReader;
import services.PageObjectManager;

public class HomeDef {

	HomePage homePage = PageObjectManager.getHomePage();
	

	@Given("user is on home page")
	public void user_is_on_home_page() {
		PageObjectManager.launch();
		homePage.verifyHomePage();
	}

	@Given("click on login button")
	public void click_on_login_button() {
		homePage.gotoLoginPage();
	}

	@When("search for a product")
	public void search_for_a_product() {
		homePage.searchProdct();
	}
	
	@When("search for a wrong product")
	public void search_for_a_wrong_product() {
		homePage.searchWrongProdct();
	}
	
	

	@When("select the searched product")
	public void select_the_searched_product() {
		homePage.selectProduct();
	}
	
	@Then("goto the order page")
	public void goto_the_order_page() {
		homePage.clickOrderButton();
	}
	
	@Then("logout the user")
	public void logout_the_user() {
		homePage.clickLogoutButton();
		
	}

}
