package com.nopcommerce.user;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;
//Mỗi lần chuyển trang phải lặp đi lặp lại hàm new Object quá nhiều lần.
//Khởi tạo object của mỗi trang nằm ở tầng testcase
//homePage = new HomePageObject(driver);
//loginPage = new LoginPageObject(driver);
//registerPage  = new RegisterPageObject(driver);
public class TC_01_Lv06_Page_Generator_Manager_I extends BaseTest{
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
		//1
		homePage = new UserHomePageObject(driver);
		
		firstName = "Automation";
		lastName = "FC";
		passWord = "123456";
		emailAddress = "afc" + fakeNumber() + "@gmail.com";
		invalidEmail = "TANNN@Tannn###$%@!@.com";
		unregisterEmail = "asdjskladjasd@gmail.com";
		wrongPassword = "9999999";
		
		registerPage  = new UserRegisterPageObject(driver);
		
		//2
		
		registerPage.inputFirstNameTextBox(firstName);
		registerPage.inputLastNameTextBox(lastName);
		registerPage.inputEmailTextBox(emailAddress);
		registerPage.inputPasswordTextBox(passWord);
		registerPage.inputConfirmPasswordTextBox(passWord);
		System.out.println("Precondition: Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		System.out.println("Precondition: Step 04: Verify message success");
		Assert.assertEquals(registerPage.getEmailSuccessMessage(), "Your registration completed");
		
		registerPage.clickToLogouLink();
		//3
		homePage = new UserHomePageObject(driver);
	}

	
	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Login 01: Step 01: Click to Login link");
		homePage.clickToLoginLink();
		
		//4
		loginPage = new UserLoginPageObject(driver);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorEmailMessage(), "Please enter your email");
		
	}
	@Test
	public void Login_02_Invalid_Email() {
		homePage.clickToLoginLink();
		//5
		loginPage = new UserLoginPageObject(driver);
		
		loginPage.inputEmailTextBox(invalidEmail);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorEmailMessage(), "Wrong email");
	}
	@Test
	public void Login_03_UnRegister_Email() {
		homePage.clickToLoginLink();
		//6
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputEmailTextBox(unregisterEmail);
		loginPage.inputPasswordTextBox(passWord);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
		
	}
	@Test
	public void Login_04_Email_NoInput_Password() {
		homePage.clickToLoginLink();
		//7
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputEmailTextBox(emailAddress);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		
	}
	@Test
	public void Login_05_Email_Wrong_Password() {
		homePage.clickToLoginLink();
		//8
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputEmailTextBox(emailAddress);
		loginPage.inputPasswordTextBox(wrongPassword);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		
	}
	@Test
	public void Login_06_Email_Password_Sucessfully () {
		homePage.clickToLoginLink();
		//9
		loginPage = new UserLoginPageObject(driver);
		
		loginPage.inputEmailTextBox(emailAddress);
		loginPage.inputPasswordTextBox(passWord);
		loginPage.clickToLoginButton();
		
		//10
		homePage = new UserHomePageObject(driver);
		Assert.assertEquals(homePage.getMyAccountText(), "My account");
		
	}
	
	
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
