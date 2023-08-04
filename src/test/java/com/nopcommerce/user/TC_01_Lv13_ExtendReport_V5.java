package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.UserAddressesPageObject;
import pageObjects.user.UserChangePasswordPageObject;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserOrderPageObject;
import pageObjects.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

@Listeners(commons.MethodListener.class)
public class TC_01_Lv13_ExtendReport_V5 extends BaseTest {
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
		firstName = "Automation";
		lastName = "FC";
		passWord = "123456";
		emailAddress = "afc" + fakeNumber() + "@gmail.com";

	}

	@Test
	public void TC_01_Register_Account(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Register_Account");
		ExtentTestManager.getTest().log(Status.INFO, "Register Account - Step 01: Click to register button");
		registerPage = homePage.clickToRegisterLink();

		ExtentTestManager.getTest().log(Status.INFO, "Register Account - Step 02: Input into FirstName textbox value is: " + firstName);
		registerPage.inputFirstNameTextBox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register Account - Step 03: Input into LastName textbox value is: " + lastName);
		registerPage.inputLastNameTextBox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register Account - Step 04: Input into Email textbox value is: " + emailAddress);
		registerPage.inputEmailTextBox(emailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Register Account - Step 05: Input into Password textbox value is: " + passWord);
		registerPage.inputPasswordTextBox(passWord);

		ExtentTestManager.getTest().log(Status.INFO, "Register Account - Step 06: Input into Confirm Password textbox value is: " + passWord);
		registerPage.inputConfirmPasswordTextBox(passWord);

		ExtentTestManager.getTest().log(Status.INFO, "Register Account - Step 07: Click to register button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register Account - Step 08: Verify register message success");
		Assert.assertEquals(registerPage.getEmailSuccessMessage(), "Your registration completed");

	}

	@Test
	public void TC_02_Login_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_02_Login_Page");
		ExtentTestManager.getTest().log(Status.INFO, "Login Account - Step 01: Click to login button");
		loginPage = homePage.clickToLoginLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Login Account - Step 02: Input to email address value is: " + emailAddress);
		loginPage.inputEmailTextBox(emailAddress);
		
		ExtentTestManager.getTest().log(Status.INFO, "Login Account - Step 03: Input to email password value is:" + passWord);
		loginPage.inputPasswordTextBox(passWord);
		
		ExtentTestManager.getTest().log(Status.INFO, "Login Account - Step 04: Click to login button");
		loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Login Account - Step 05: Verify 'My Account' text");
		Assert.assertEquals(homePage.getMyAccountText(), "My accountt");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login Account - Step 06: Click to 'My Account' text");
		customerInfo = homePage.clicktoMyAccountLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Login Account - Step 07: Verify 'Customer info' text");
		Assert.assertFalse(customerInfo.isTitleDisplayed(driver));
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
}
