package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.user.UserAddressesPageObject;
import pageObjects.user.UserChangePasswordPageObject;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserOrderPageObject;
import pageObjects.user.UserRegisterPageObject;


@Epic("Regression Test")
@Feature("Register & Login")
public class TC_01_Lv13_Allure_Report extends BaseTest {
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
	@Description("TC_01_Register_Account")
	@Story("Register Account to login system")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_01_Register_Account(Method method) {
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputFirstNameTextBox(firstName);

		registerPage.inputLastNameTextBox(lastName);

		registerPage.inputEmailTextBox(emailAddress);

		registerPage.inputPasswordTextBox(passWord);

		registerPage.inputConfirmPasswordTextBox(passWord);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getEmailSuccessMessage(), "Your registration completed");

	}
	@Description("TC_02_Login_Page")
	@Story("Login system")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_02_Login_Page(Method method) {
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputEmailTextBox(emailAddress);
		
		loginPage.inputPasswordTextBox(passWord);
		
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(homePage.getMyAccountText(), "My accountt");
		
		customerInfo = homePage.clicktoMyAccountLink();
		
		Assert.assertFalse(customerInfo.isTitleDisplayed(driver));
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
}
