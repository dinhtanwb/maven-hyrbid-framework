package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstances;
import commons.PageGeneratorManager;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.UserAddressesPageObject;
import pageObjects.user.UserChangePasswordPageObject;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserOrderPageObject;
import pageObjects.user.UserRegisterPageObject;
import pageUIs.admin.AdminBaseUI;

public class TC_01_Lv07_Switch_Role extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultipleBrowser(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		passWord = "123456";
		emailAddress = "afc123@gmail.com";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";
	}

	@Test
	public void Login_01_Login_As_UserRole() {

		userLoginPage = userHomePage.clickToLoginLink();
		userHomePage = userLoginPage.loginAsUser(emailAddress, passWord);
		Assert.assertEquals(userHomePage.getMyAccountText(), "My account");
		
	}

	@Test
	public void Login_02_Login_As_AdminRole() {
		userHomePage.openPageURL(driver, GlobalConstances.ADMIN_DEV_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminDashboard = adminLoginPage.login_As_Admin_Role(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboard.isDisplayHeader());
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
	String firstName, lastName, passWord, emailAddress, adminEmailAddress, adminPassword;
	UserRegisterPageObject userRegisterPage;
	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	UserCustomerInfoPageObject userCustomerInfo;
	UserAddressesPageObject userAddressPage;
	UserOrderPageObject userOrderPage;
	UserChangePasswordPageObject userChangepasswordPage;
	AdminLoginPageObject adminLoginPage;
	AdminDashboardPageObject adminDashboard;

}
