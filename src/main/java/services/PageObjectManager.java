package services;

import com.microsoft.playwright.Page;

import pages.AccountPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderPage;
import pages.ProductDetailsPage;
import pages.WishlistPage;

public class PageObjectManager extends InitFactory {

	static Page page = SetUp();

	private static LoginPage loginPage;
	private static HomePage homePage;
	private static AccountPage accountPage;
	private static ProductDetailsPage productDetailsPage;
	private static CartPage cartPage;
	private static OrderPage orderPage;
	private static CheckoutPage checkoutPage;
	private static WishlistPage wishlistPage;

	private PageObjectManager() {
	}

	public static LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(page) : loginPage;
	}

	public static HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(page) : homePage;
	}

	public static ProductDetailsPage getProductDetailsPage() {
		return (productDetailsPage == null) ? productDetailsPage = new ProductDetailsPage(page) : productDetailsPage;
	}

	public static CartPage getCartPage() {
		return (cartPage == null) ? cartPage = new CartPage(page) : cartPage;
	}

	public static AccountPage getAccountPage() {
		return (accountPage == null) ? accountPage = new AccountPage(page) : accountPage;
	}

	public static OrderPage getOrderPage() {
		return (orderPage == null) ? orderPage = new OrderPage(page) : orderPage;
	}

	public static CheckoutPage getCheckoutPage() {
		return (checkoutPage == null) ? checkoutPage = new CheckoutPage(page) : checkoutPage;
	}

	public static WishlistPage getWishlistPage() {
		return (wishlistPage == null) ? wishlistPage = new WishlistPage(page) : wishlistPage;
	}
}
