package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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

public class TC_01_Lv08_Dynamic_Locator extends BaseTest {
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
	public void Login_01_Register_My_Account() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputFirstNameTextBox(firstName);
		registerPage.inputLastNameTextBox(lastName);
		registerPage.inputEmailTextBox(emailAddress);
		registerPage.inputPasswordTextBox(passWord);
		registerPage.inputConfirmPasswordTextBox(passWord);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getEmailSuccessMessage(), "Your registration completed");

		loginPage = homePage.clickToLoginLink();
		loginPage.inputEmailTextBox(emailAddress);
		loginPage.inputPasswordTextBox(passWord);
		loginPage.clickToLoginButton();
		Assert.assertEquals(homePage.getMyAccountText(), "My account");
		customerInfo = homePage.clicktoMyAccountLink();
		Assert.assertTrue(customerInfo.isTitleDisplayed(driver));
	}

	@Test
	public void Login_02_Switch_Page() {
		// Bị lặp lại giữa các case: customerInfo có function openAddress
		// changepassword cũng có function openPageAddress
		// Solution --> Viet gom vao BasePage

		// CustomerInfo --> Addresses
		addressPage = customerInfo.openAddressLink(driver);

		// Address --> Orders
		orderPage = addressPage.openOrderLink(driver);
		// Orders --> Change password
		changepasswordPage = orderPage.openChangePasswordLink(driver);
		// Change password --> Address
		addressPage = changepasswordPage.openAddressLink(driver);
		// Address --> CustomerInfo
		customerInfo = addressPage.openCustomerInfoLink(driver);
		// CustomerInfo --> Order
		orderPage = customerInfo.openOrderLink(driver);
	}

	@Test
	public void Login_03_Apply_DynamicLocator_First_Way() {

		customerInfo = (UserCustomerInfoPageObject) orderPage.openPageObjectByName(driver, "Customer info");
		changepasswordPage = (UserChangePasswordPageObject) customerInfo.openPageObjectByName(driver, "Change password");
		orderPage = (UserOrderPageObject) customerInfo.openPageObjectByName(driver, "Orders");
		addressPage = (UserAddressesPageObject) orderPage.openPageObjectByName(driver, "Addresses");
	}

	@Test
	public void Login_04_Apply_DynamicLocator_Second_Way() {

		orderPage.openPageObjectByName_(driver, "Customer info");
		PageGeneratorManager.getOrderPage(driver);
		customerInfo.openPageObjectByName_(driver, "Change password");
		PageGeneratorManager.getUserCustomerInfoPage(driver);
		customerInfo.openPageObjectByName_(driver, "Orders");
		PageGeneratorManager.getUserCustomerInfoPage(driver);
		orderPage.openPageObjectByName_(driver, "Addresses");
		PageGeneratorManager.getOrderPage(driver);
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
}
