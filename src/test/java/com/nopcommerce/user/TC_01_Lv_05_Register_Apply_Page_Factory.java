package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserRegisterPageObject;

public class TC_01_Lv_05_Register_Apply_Page_Factory extends BaseTest{
	WebDriver driver;
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	String firstName, lastName, password;

	String projectPath = System.getProperty("user.dir");
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultipleBrowser(browserName);
		
		homePage = new UserHomePageObject(driver);	
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
	}

	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Register_01: Step 01: Click to Register link");
		registerPage = new UserRegisterPageObject(driver);
		homePage.clickToRegisterLink();
		System.out.println("Register_01: Step 02: Click to Register button");
		registerPage.clickToRegisterButton();
		System.out.println("Register_01: Step 03: Verify message error");
		Assert.assertEquals(registerPage.getFirstNameError(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameError(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailError(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordError(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmError(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		registerPage = new UserRegisterPageObject(driver);
		System.out.println("Register_02: Step 01: Click to Register link");
		homePage.clickToRegisterLink();
		System.out.println("Register_02: Step 02: Input wrong email");
		registerPage.inputEmailTextBox("12312323@444421@!#$@");
		System.out.println("Register_02: Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		System.out.println("Register_02: Step 04: Verify message error");
		Assert.assertEquals(registerPage.getEmailError(), "Wrong email");
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
