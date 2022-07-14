package services;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utils.Utils;

public class InitFactory {

	static Browser browser;
	static String baseURL = "https://demo.opencart.com/";
	static Page page;
	static BrowserContext browserContext;
	static ConfigReader cfReader;
	static Utils util = new Utils();


	public static Page SetUp() {
		browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//		browserContext = browser.newContext();
		browserContext = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
		page = browserContext.newPage();
		return page;
	}

	public static void launch() {
		page.navigate(new ConfigReader().getPropertyValue("base_url"));
	}
	
	public static void closeContext() {
		browserContext.close();
	}

}
