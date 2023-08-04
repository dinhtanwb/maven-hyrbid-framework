package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;

public class TC_02_Login extends BaseTest{
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	UserRegisterPageObject registerPage;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	String firstName, lastName, passWord, emailAddress, invalidEmail, unregisterEmail, wrongPassword;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		
		driver = openMultipleBrowser(browserName);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Automation";
		lastName = "FC";
		passWord = "123456";
		emailAddress = "afc" + fakeNumber() + "@gmail.com";
		invalidEmail = "TANNN@Tannn###$%@!@.com";
		unregisterEmail = "asdjskladjasd@gmail.com";
		wrongPassword = "9999999";
		registerPage = homePage.clickToRegisterLink();
		
		//pre-condition
		registerPage.inputFirstNameTextBox(firstName);
		registerPage.inputLastNameTextBox(lastName);
		registerPage.inputEmailTextBox(emailAddress);
		registerPage.inputPasswordTextBox(passWord);
		registerPage.inputConfirmPasswordTextBox(passWord);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getEmailSuccessMessage(), "Your registration completed");
	}
	public int fakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	@Test
	public void Login_01_Empty_Data() {
		loginPage = homePage.clickToLoginLink();
		
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorEmailMessage(), "Please enter your email");
		
	}
	@Test
	public void Login_02_Invalid_Email() {
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputEmailTextBox(invalidEmail);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorEmailMessage(), "Wrong email");
	}
	@Test
	public void Login_03_UnRegister_Email() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputEmailTextBox(unregisterEmail);
		loginPage.inputPasswordTextBox(passWord);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
		
	}
	@Test
	public void Login_04_Email_NoInput_Password() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputEmailTextBox(emailAddress);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		
	}
	@Test
	public void Login_05_Email_Wrong_Password() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputEmailTextBox(emailAddress);
		loginPage.inputPasswordTextBox(wrongPassword);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		
	}
	@Test
	public void Login_06_Email_Password_Sucessfully () {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputEmailTextBox(emailAddress);
		loginPage.inputPasswordTextBox(passWord);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(homePage.getMyAccountText(), "My account");
		
	}
	
	
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
