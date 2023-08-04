package com.nopcommerce.user;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
public class TC_01_Lv11_Custom_Assert extends BaseTest {
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
		verifyEquals(registerPage.getEmailSuccessMessage(), "Your registration completedt");

		loginPage = homePage.clickToLoginLink();
		loginPage.inputEmailTextBox(emailAddress);
		loginPage.inputPasswordTextBox(passWord);
		loginPage.clickToLoginButton();
		verifyEquals(homePage.getMyAccountText(), "My accountt");
		customerInfo = homePage.clicktoMyAccountLink();
		verifyFalse(customerInfo.isTitleDisplayed(driver));
	}

//	@Test
	public void Login_02_Switch_Page() {
		// Bị lặp lại giữa các case: customerInfo có function openAddress
		// changepassword cũng có function openPageAddress
		// Solution --> Viet gom vao BasePage

		addressPage = customerInfo.openAddressLink(driver);
		orderPage = addressPage.openOrderLink(driver);
		changepasswordPage = orderPage.openChangePasswordLink(driver);
		addressPage = changepasswordPage.openAddressLink(driver);
		customerInfo = addressPage.openCustomerInfoLink(driver);
		orderPage = customerInfo.openOrderLink(driver);
	}

//	@Test
	public void Login_03_Apply_DynamicLocator_First_Way() {

		customerInfo = (UserCustomerInfoPageObject) orderPage.openPageObjectByName(driver, "Customer info");
		changepasswordPage = (UserChangePasswordPageObject) customerInfo.openPageObjectByName(driver, "Change password");
		orderPage = (UserOrderPageObject) customerInfo.openPageObjectByName(driver, "Orders");
		addressPage = (UserAddressesPageObject) orderPage.openPageObjectByName(driver, "Addresses");
	}

//	@Test
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
