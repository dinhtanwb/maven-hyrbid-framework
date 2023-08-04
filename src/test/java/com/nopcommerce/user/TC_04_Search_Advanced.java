package com.nopcommerce.user;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.UserSearchPageObject;
import pageUIs.user.UserSearchPageUI;

public class TC_04_Search_Advanced extends BaseTest	 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserCustomerInfoPageObject customerInfo;
	UserSearchPageObject searchPage;
	
	String firstName, lastName, passWord, email, textArea, dynamicValue;
	 
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultipleBrowser(browserName);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//precondition
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Automation";
		lastName = "FC";
		passWord = "123456";
		email = "afc" + fakeNumber() + "@gmail.com";
		textArea = "Customer service";
		dynamicValue = "Search";
		registerPage = homePage.clickToRegisterLink();

		// pre-condition
		homePage = registerPage.registerAccount(firstName, lastName, email, passWord);
		Assert.assertEquals(registerPage.getEmailSuccessMessage(), "Your registration completed");
		loginPage = homePage.clickToLoginLink();
		homePage = loginPage.loginAsUser(email, passWord);
		customerInfo = homePage.clicktoMyAccountLink();
		Assert.assertTrue(customerInfo.isTitleDisplayed(driver));
		searchPage = customerInfo.openSearchLink(driver, UserSearchPageUI.SEARCH_LINK, textArea, dynamicValue);
	}
	@Test
	public void TC_01_Search_Emty_Data() {
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getTextErrorMessage(), "Search term minimum length is 3 characters");
	}

	@Test
	public void TC_02_Search_Data_Not_Exist() {
		searchPage.inputSearchTextBox("Macbook Pro 2050");
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getTextNoResultMessage(), "No products were found that matched your criteria.");
	}

	@Test
	public void TC_03_Search_Data_Relative() {
		searchPage.inputSearchTextBox("Lenovo");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.getListProductTitle("Lenovo"));
		
	}

	@Test
	public void TC_04_Search_Data_Absolute() {
		searchPage.inputSearchTextBox("Thinkpad X1 Carbon");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.getListProductTitle("Thinkpad X1 Carbon"));
	}
	@Test
	public void TC_05_Search_With_Parent_Category() {
		Assert.assertFalse(searchPage.isElementSelected(driver, UserSearchPageUI.SEARCH_ADVANCE_CHECKBOX));
		searchPage.searchWithParentCategory("Computers");
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getTextNoResultMessage(), "No products were found that matched your criteria.");
	}
	@Test
	public void TC_06_Search_With_Sub_Category() {
		Assert.assertTrue(searchPage.isElementSelected(driver, UserSearchPageUI.SEARCH_ADVANCE_CHECKBOX));
		searchPage.inputSearchTextBox("Apple Macbook Pro");
		searchPage.searchWithParentCategory("Computers");
		Assert.assertFalse(searchPage.isElementSelected(driver,UserSearchPageUI.SUB_CATEGORY_CHECKBOX));
		searchPage.clickToSubCategoryCheckBox();
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.getListProductTitle("Apple MacBook Pro"));
	}
	
	@Test
	public void TC_07_Search_With_Incorrect_Manufacturer() {
		searchPage.inputSearchTextBox("Apple Macbook Pro");
		Assert.assertTrue(searchPage.isElementSelected(driver, UserSearchPageUI.SEARCH_ADVANCE_CHECKBOX));
		searchPage.searchWithParentCategory("Computers");
		Assert.assertTrue(searchPage.isElementSelected(driver,UserSearchPageUI.SUB_CATEGORY_CHECKBOX));
		searchPage.selectManufacturerDropdown("HP");
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getTextNoResultMessage(), "No products were found that matched your criteria.");
	}
	
	
	@Test
	public void TC_08_Search_With_Correct_Manufacturer() {
		searchPage.inputSearchTextBox("Apple Macbook Pro");
		Assert.assertTrue(searchPage.isElementSelected(driver, UserSearchPageUI.SEARCH_ADVANCE_CHECKBOX));
		searchPage.searchWithParentCategory("Computers");
		Assert.assertTrue(searchPage.isElementSelected(driver,UserSearchPageUI.SUB_CATEGORY_CHECKBOX));
		searchPage.selectManufacturerDropdown("Apple");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.getListProductTitle("Apple MacBook Pro"));
	}
	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
