package utils;

import java.util.HashMap;

public class Constants {

	public static HashMap<String, String> productMap = new HashMap<>();

	public static final String BASE_URL = "https://demo.opencart.com/";
	public static final String storeLogo = "Your Store";
	
	public static final String HomePageTitle = "Your Store";
	public static final String AccountPageTitle = "My Account";
	public static final String LoginPageTitle = "Account Login";
	public static final String searchPageTitle = "Search - ";
	public static final String CartPageTitle = "Shopping Cart";
	public static final String CheckoutPageTitle = "Checkout";
	public static final String OrderPageTitle = "Order History";
	public static final String WishlistPageTitle = "My Wish List";


	
	public static final String[] accountPageAllTitles = {"My Account", "My Orders", "My Affiliate Account", "Newsletter"};

	
	public static final String productAvail = "Availability: In Stock";
	public static final String productNotAvail = "Availability: Out Of Stock";
	
	public static final String addToCartSuccess = "Success: You have added * to your shopping cart!";
	public static final String addToWishlistSuccess = " Success: You have added * to your wish list!";
	public static final String placedSuccess = "Your order has been placed!";
	public static final String removedSuccessFromWishlist = "Success: You have modified your wish list!";
	
	public static final String productName = "PRODUCT_NAME";
	public static final String productModel = "PRODUCT_MODEL";
	public static final String productQuantity = "PRODUCT_QUANTITY";
	public static final String productUnitPrice = "PRODUCT_UNIT_PRICE";
	public static final String productTotalPrice = "PRODUCT_TOTAL_PRICE";
	public static final String productStock = "PRODUCT_STOCK";
	
	
	public static final String labelBillingDetailsExistingAddress = "I want to use an existing address";
	public static final String labelBillingDetailsNewAddress = "I want to use a new address";
	public static final String labelDeliveryDetailsExistingAddress = "I want to use an existing address";
	public static final String labelDeliveryDetailsNewAddress = "I want to use a new address";
	public static final String labelDeliveryMethodFlatRate = "Flat Shipping Rate";
	public static final String labelPaymentMethodCOD = "Cash On Delivery";
	
	public static final String labelEmptyWishlist = "Your wish list is empty.";

}
