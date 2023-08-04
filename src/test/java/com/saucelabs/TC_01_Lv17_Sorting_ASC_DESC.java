package com.saucelabs;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.saucelabs.HomePO;
import pageObjects.saucelabs.LoginHomePO;
import pageObjects.saucelabs.PageGeneratorManager;

@Listeners(commons.MethodListener.class)
public class TC_01_Lv17_Sorting_ASC_DESC extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = openMultipleBrowser(browserName, url);
		loginHome = PageGeneratorManager.getLoginHomePO(driver);
		loginHome.enterToUserNameTextBox("standard_user");
		loginHome.enterToPasswordTextBox("secret_sauce");
		home = loginHome.clicktoLoginButton();
	}

//	@Test
	public void TC_01_SORT_NAME() {
		home.clickToProductSortDropdownByText("Name (A to Z)");
		verifyTrue(home.isSortingProductByASC());
		
		home.clickToProductSortDropdownByText("Name (Z to A)");
		verifyTrue(home.isSortingProductByDESC());
	}

	@Test
	public void TC_02_SORT_PRICE() {
		home.clickToProductSortDropdownByText("Price (low to high)");
		verifyTrue(home.isSortingProductByPriceASC());
		
		home.clickToProductSortDropdownByText("Price (high to low)");
		verifyTrue(home.isSortingProductByPriceDESC());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	WebDriver driver;
	LoginHomePO loginHome;
	HomePO home;
}
