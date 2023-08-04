package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

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
public class Common_Level_02_Login_With_Cookie extends BaseTest {
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
	public static Set<Cookie> cookies;

	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driver = openMultipleBrowser(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Automation";
		lastName = "FC";
		passWord = "123456";
		emailAddress = "afc" + fakeNumber() + "@gmail.com";

		log.info("Pre - Condition - Step 01: Click to register button");
		registerPage = homePage.clickToRegisterLink();

		log.info("Pre - Condition - Step 02: Input into FirstName textbox value is: " + firstName);
		registerPage.inputFirstNameTextBox(firstName);

		log.info("Pre - Condition - Step 03: Input into LastName textbox value is: " + lastName);
		registerPage.inputLastNameTextBox(lastName);

		log.info("Pre - Condition - Step 04: Input into Email textbox value is: " + emailAddress);
		registerPage.inputEmailTextBox(emailAddress);

		log.info("Pre - Condition - Step 05: Input into Password textbox value is: " + passWord);
		registerPage.inputPasswordTextBox(passWord);

		log.info("Pre - Condition - Step 06: Input into Confirm Password textbox value is: " + passWord);
		registerPage.inputConfirmPasswordTextBox(passWord);

		log.info("Pre - Condition - Step 07: Click to register button");
		registerPage.clickToRegisterButton();

		log.info("Pre - Condition - Step 08: Verify register message success");
		Assert.assertEquals(registerPage.getEmailSuccessMessage(), "Your registration completedttt");
		
		log.info("Pre - Condition - Step 09: Click to login button");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Pre - Condition - Step 10: Input username value is: " + emailAddress);
		loginPage.inputEmailTextBox(emailAddress);
		
		log.info("Pre - Condition - Step 11: Input password value is: " + passWord);
		loginPage.inputPasswordTextBox(passWord);
		
		log.info("Pre - Condition - Step 12: Click to login");
		loginPage.clickToLoginButton();
		
		
		cookies = registerPage.getAllCookie(driver);
		
	}

	@AfterTest (alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
