package com.nopcommerce.user;

import java.util.Comparator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
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
import pageObjects.user.UserNoteBookPageObject;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.UserSearchPageObject;

public class TC_05_Sort_DisPlay_Paging extends BaseTest	 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserCustomerInfoPageObject customerInfo;
	UserSearchPageObject searchPage;
	UserNoteBookPageObject noteBookPage;
	
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
		noteBookPage = customerInfo.openNoteBookProduct(driver);
		Assert.assertTrue(noteBookPage.isDisplayHeader());
	}
	@Test
	public void TC_01_Sort_Name() {
		noteBookPage.clickToSortDropdownByText("Name: A to Z");
		
		noteBookPage.isItemSortingByASC();
		
		noteBookPage.isItemSortingByDESC();
	}
	
	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
}
