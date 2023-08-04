package com.nopcommerce.user;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_Level_01_Register_New_Account;
import com.nopcommerce.common.Common_Level_02_Login_With_Cookie;

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
public class TC_01_Lv14_Apply_Cookie_To_Login_Page extends BaseTest {
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
	}

	@Test
	public void TC_02_Login_Page() {
		log.info("Login Account - Step 01: Click to login button");
		loginPage = homePage.clickToLoginLink();
		log.info("Login Account - Step 02: Set cookie and reload page");
		Set <Cookie> cookies = Common_Level_02_Login_With_Cookie.cookies;
		loginPage.setCookie(driver, cookies);
		loginPage.refreshBrowser(driver);
		
		
		
		log.info("Login Account - Step 03: Verify 'My Account' text");
		Assert.assertEquals(homePage.getMyAccountText(), "My account");
	}

	@AfterClass
	public void afterClass() {
		 driver.quit();
	}
}
