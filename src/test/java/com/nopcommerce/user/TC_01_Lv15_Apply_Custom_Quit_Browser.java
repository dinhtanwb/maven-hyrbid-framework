package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_Level_01_Register_New_Account;

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
public class TC_01_Lv15_Apply_Custom_Quit_Browser extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	UserRegisterPageObject registerPage;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserCustomerInfoPageObject customerInfo;
	UserAddressesPageObject addressPage;
	UserOrderPageObject orderPage;
	UserChangePasswordPageObject changepasswordPage;
	String firstName, lastName, passWord, emailAddress;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultipleBrowser(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		emailAddress = Common_Level_01_Register_New_Account.emailAddress;
		passWord = Common_Level_01_Register_New_Account.passWord;
		
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
		Assert.assertEquals(registerPage.getEmailSuccessMessage(), "Your registration completed...");
		
		log.info("Pre - Condition - Step 09: Click to login button");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Pre - Condition - Step 10: Input username value is: " + emailAddress);
		loginPage.inputEmailTextBox(emailAddress);
		
		log.info("Pre - Condition - Step 11: Input password value is: " + passWord);
		loginPage.inputPasswordTextBox(passWord);
		
		log.info("Pre - Condition - Step 12: Click to login");
		loginPage.clickToLoginButton();
		
		
		
		
	}

	@Test
	public void TC_01_Login_Page() {
		log.info("Login Account - Step 01: Click to login button");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login Account - Step 02: Input to email address value is: " + emailAddress);
		loginPage.inputEmailTextBox(emailAddress);
		
		log.info("Login Account - Step 03: Input to email password value is:" + passWord);
		loginPage.inputPasswordTextBox(passWord);
		
		log.info("Login Account - Step 04: Click to login button");
		loginPage.clickToLoginButton();
		
		log.info("Login Account - Step 05: Verify 'My Account' text");
		Assert.assertEquals(homePage.getMyAccountText(), "My account");
	}

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
