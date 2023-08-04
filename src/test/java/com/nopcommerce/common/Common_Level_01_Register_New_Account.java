package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.UserAddressesPageObject;
import pageObjects.user.UserChangePasswordPageObject;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserOrderPageObject;
import pageObjects.user.UserRegisterPageObject;

@Listeners(commons.MethodListener.class)
public class Common_Level_01_Register_New_Account extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	UserRegisterPageObject registerPage;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserCustomerInfoPageObject customerInfo;
	UserAddressesPageObject addressPage;
	UserOrderPageObject orderPage;
	UserChangePasswordPageObject changepasswordPage;
	String firstName, lastName;
	public static String passWord, emailAddress;

	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driver = openMultipleBrowser(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Automation";
		lastName = "FC";
		passWord = "123456";
		emailAddress = "afc" + fakeNumber() + "@gmail.com";

		log.info("Register Account - Step 01: Click to register button");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register Account - Step 02: Input into FirstName textbox value is: " + firstName);
		registerPage.inputFirstNameTextBox(firstName);

		log.info("Register Account - Step 03: Input into LastName textbox value is: " + lastName);
		registerPage.inputLastNameTextBox(lastName);

		log.info("Register Account - Step 04: Input into Email textbox value is: " + emailAddress);
		registerPage.inputEmailTextBox(emailAddress);

		log.info("Register Account - Step 05: Input into Password textbox value is: " + passWord);
		registerPage.inputPasswordTextBox(passWord);

		log.info("Register Account - Step 06: Input into Confirm Password textbox value is: " + passWord);
		registerPage.inputConfirmPasswordTextBox(passWord);

		log.info("Register Account - Step 07: Click to register button");
		registerPage.clickToRegisterButton();

		log.info("Register Account - Step 08: Verify register message success");
		Assert.assertEquals(registerPage.getEmailSuccessMessage(), "Your registration completed");

	}

	@AfterTest
	public void afterClass() {
		// driver.quit();
	}
}
